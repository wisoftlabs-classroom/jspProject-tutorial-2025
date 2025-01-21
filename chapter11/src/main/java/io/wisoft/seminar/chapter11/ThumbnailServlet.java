package io.wisoft.seminar.chapter11;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.imageio.ImageIO;

@WebServlet("/ThumbnailServlet")
@MultipartConfig(location = "your working directory + /jsp-project-tutorial-2025/chapter11/src/main/webapp/image", fileSizeThreshold =
        1024 * 1024, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024 * 100 * 5)
public class ThumbnailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String imagePath = request.getServletContext().getRealPath("/image");

        Part part = request.getPart("filename");
        String filename = getFileName(part);

        String filePath = imagePath + File.separator + filename;

        try (InputStream input = part.getInputStream(); OutputStream output = Files.newOutputStream(
                new File(filePath).toPath())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        createThumbnail(imagePath, filename);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>이미지 썸네일 예제</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("-원본 이미지-<br>");
        response.getWriter().println("<img src=\"image/" + filename + "\"><p>");
        response.getWriter().println("-썸네일 이미지-<br>");
        response.getWriter().println("<img src=\"image/sm_" + filename + "\">");
        response.getWriter().println("</body></html>");
    }

    private void createThumbnail(String uploadDirectory, String uploadFileName) {
        try {
            String imagePath = uploadDirectory + File.separator + uploadFileName;

//          ParameterBlock pb = new ParameterBlock();
//          pb.add(imagePath);
//          RenderedOp rOp = JAI.create("fileload", pb);
            BufferedImage bi = loadImage(imagePath);

            BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = thumb.createGraphics();
            g.drawImage(bi, 0, 0, 100, 100, null);

            File thumbnailFile = new File(uploadDirectory + File.separator + "sm_" + uploadFileName);
            ImageIO.write(thumb, "jpg", thumbnailFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf(File.separator) + 1);
            }
        }
        return null;
    }

    public static BufferedImage loadImage(String filePath) throws IOException {
        File file = new File(filePath);
        return ImageIO.read(file);  // 이미지 파일을 BufferedImage로 읽기
    }
}

