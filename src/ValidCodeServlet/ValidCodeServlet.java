package ValidCodeServlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.prism.Image;

/**
 * ��֤��
 * 
 * @author liqingkun7
 *
 */
@WebServlet("/ValidCodeServlet")
public class ValidCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String[] src = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "0", "2", "3", "4", "5", "6", "7", "8", "9" };

	private Random random = new Random();

	/**
	 * ����Get����
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ�������
		// ����ҵ���߼�
		// ������Ӧ
		ServletOutputStream sos = resp.getOutputStream();
		// 1��������֤��
		String rs = randomString(4);
		System.out.println(rs + " ��֤��--------");
		
		//����֤����ӵ�session��
		HttpSession session = req.getSession();
		session.setAttribute("vcs", rs);
		
		
		renderImage(rs, sos, 80, 20);
	}

	public String randomString(int length) {
		String rs = ""; // ������֤����ֵ
		for (int i = 0; i < length; i++) {
			rs += src[random.nextInt(src.length)];
		}
		return rs;
	}

	/**
	 * 
	 * @param src
	 *            4λ��֤��
	 * @param width
	 *            //ͼƬ���
	 * @param height
	 *            //ͼƬ�߶�
	 * @throws IOException
	 */
	public void renderImage(String src, ServletOutputStream sos, int width, int height) throws IOException {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		// ������
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		// ���ַ���
		g.setColor(randColor(10, 255));
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString(src, 10, height - 1);
		
		// ������Ȧ
		g.setColor(randColor(150, 250));
		for (int i = 0; i < 10; i++) {
			g.drawOval(random.nextInt(width - 10), random.nextInt(height - 10), random.nextInt(10) + 5,
					random.nextInt(10) + 5);
		}

		// ���
		ImageIO.write(img, "png", sos);
	}

	public Color randColor(int min, int max) {
		if (min > 255) {
			min = 255;
		}
		if (max > 255) {
			max = 255;
		}

		int r = random.nextInt(max - min) + min;
		int g = random.nextInt(max - min) + min;
		int b = random.nextInt(max - min) + min;

		return new Color(r, g, b);
	}

}
