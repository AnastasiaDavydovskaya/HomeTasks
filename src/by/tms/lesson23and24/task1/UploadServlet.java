package by.tms.lesson23and24.task1;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "upload", urlPatterns = {"/file/upload/result"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 МБ
        maxFileSize = 1024 * 1024 * 10,  // 10 МБ
        maxRequestSize = 1024 * 1024 * 100 // 100МБ
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for(Part part: request.getParts()) {
            part.write("D:\\HomeTasks\\" + fileName);
        }
        response.getWriter().print("The file uploaded successfully");
    }
}
