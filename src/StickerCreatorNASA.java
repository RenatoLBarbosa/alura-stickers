import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerCreatorNASA {

	public void create(InputStream is, String nomearquivo) throws Exception {

		BufferedImage originalimg = ImageIO.read(is);

		int largura = originalimg.getWidth();
		int altura = originalimg.getHeight();
		int novaAltura = altura + 200;

		BufferedImage newimg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		Graphics2D graphics = (Graphics2D) newimg.getGraphics();
		graphics.drawImage(originalimg, 0, 0, null);

		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		graphics.setColor(Color.RED);
		graphics.setBackground(Color.LIGHT_GRAY);
		graphics.setFont(fonte);

		graphics.drawString("NASA APOD", (largura / 2) - 120, novaAltura - 90);

		ImageIO.write(newimg, "png", new File("saida/" + nomearquivo + ".png"));

	}
}
