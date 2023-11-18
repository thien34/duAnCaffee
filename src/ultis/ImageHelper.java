package ultis;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class ImageHelper {

    public static Image logoApp() {
        File file = new File("src/image", "fpt.png");
        Image image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        return image;
    }

    public static void saveImg(File file) {
        File dir = new File("src/image", file.getName());
        // Tạo thư mục nếu chưa tồn tại 
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            // Copy vào thư mục logos (đè nếu đã tồn tại) 
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(dir.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon readImg(String fileName) {
        if (fileName == null) {
            return null;
        }
        File path = new File("src/image", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(175, 201, Image.SCALE_DEFAULT));
    }
}
