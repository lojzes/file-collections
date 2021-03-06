package com.lojzes.img;

import cn.hutool.core.img.ImgUtil;
import com.lojzes.SignatureImgUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

/**
 * 描述:
 * <p> // todo
 *
 * @author liaoyuanyuan@whyun.net.cn
 * @date 2021/10/29 16:32
 **/
public class ImageTest {

  public static void main(String[] args) throws IOException {
    // d1(30);
    // d2();
    // d3(30,"爱新觉罗张三丰");
   // d3(300, "任庆军");

    SignatureImgUtil.genImg("任庆军","d:\\test.png");

//    int fontSize = 30;
//    int width = fontSize * 3 + 4;
//    int height = fontSize + 5 ;
//
//    BufferedImage bL = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
//    Graphics2D g2 = (Graphics2D)bL.getGraphics();
//    //设置颜色
//    g2.setColor(Color.WHITE);
//    g2.fillRect(0, 0, width, height);//填充整张图片
//    g2.setColor(Color.white);//边框填色
//    g2.fillRect(0,0,width,height);
//    g2.setFont(new Font("宋体",Font.BOLD,fontSize));
//    g2.setColor(Color.BLACK);//设置颜色
//    g2.drawString("刘明树", 0, fontSize);//x,y轴
//    ImageIO.write(bL,"JPEG",new FileOutputStream("D:/a.jpg"));//保存图片

  }

  public static void d2() throws IOException {
    Font font = new Font("宋体", Font.BOLD, 30);
    Color bg = Color.white;
    Color ft = Color.BLACK;
    FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(
        new File("d:\\test.png"));
    ImgUtil.createImage("李天奇", font, bg, ft, fileImageOutputStream);
  }


  public static void d1(int fontSize) throws IOException {
    // int fontSize = 25;
    // 字体左右 距 画板的距离
    int w = 13;
    int width = fontSize * 3 + w * 2;
    int height = fontSize * 2;
    // 创建BufferedImage 对象
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // 获取画笔
    Graphics2D graphics = bufferedImage.createGraphics();
    // 设置背景色
    graphics.setColor(Color.white);
    // 画一个矩形
    graphics.fillRect(0, 0, width, height);
    // 设置字体
    Font font = new Font("楷体", Font.BOLD, fontSize);
    graphics.setFont(font);
    // 设置字体颜色
    graphics.setColor(Color.black);
    // 写字
    int y = fontSize + fontSize / 2;
    graphics.drawString("张三丰", w, y);
    // 释放对象
    graphics.dispose();
    ImageIO.write(bufferedImage, "png", new File("d:\\test.png"));
  }

  /**
   * desc.
   * <p> https://stackoverflow.com/questions/24063351/drawing-certain-parts-of-image-offset-from-the-corner
   * <p>关于坐标解释，查询 resources 下面的图片</p>
   *
   * @return void
   * @author liaoyuanyuan@whyun.net.cn
   * @date 2021/12/13 18:32
   **/
  public static void d3(int fontSize, String name) throws IOException {
    // 字体长度
    int nameCharSize = name.toCharArray().length;
    // int fontSize = 25;
    // 字体左右 距画板的距离
    int w = 3;
    // 适应字体右边的距离
    int plus = 63;
    if (nameCharSize == 2) {
      plus = 50;
    } else if (nameCharSize == 4) {
      plus = 70;
    } else if (nameCharSize == 5) {
      plus = 90;
    } else if (nameCharSize == 6) {
      plus = 100;
    } else if (nameCharSize == 7) {
      plus = 115;
    } else if (nameCharSize == 8) {
      plus = 160;
    } else if (nameCharSize == 9) {
      plus = 163;
    }

    int width = fontSize * nameCharSize + w * 2 + plus;
    int height = fontSize + 30;
    // 创建BufferedImage 对象
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // 获取画笔
    Graphics2D graphics = bufferedImage.createGraphics();
    // 设置背景色
    graphics.setColor(Color.white);
    // 画一个矩形
    graphics.fillRect(0, 0, width, height);
    // 设置字体
    Font font = new Font("宋体", Font.BOLD, fontSize);
    graphics.setFont(font);
    // 设置字体颜色
    graphics.setColor(Color.black);
    // 写字
    int y = fontSize;
    graphics.drawString(name, w, y - 25);
    // 释放对象
    graphics.dispose();

    File file = new File("d:\\test.png");
    //  ImageIO.write(bufferedImage, "png",file);

    BufferedImage source = bufferedImage;

    int borderLeft = 8;
    int borderTop = 20;

    int borderedImageWidth = width + borderLeft * 2;
    int borderedImageHeight = height + borderTop * 2;

    BufferedImage img = new BufferedImage(borderedImageWidth, borderedImageHeight,
        BufferedImage.TYPE_3BYTE_BGR);
    img.createGraphics();
    Graphics2D g = (Graphics2D) img.getGraphics();
    g.setColor(Color.black);
    g.fillRect(0, 0, borderedImageWidth, borderedImageHeight);

    g.drawImage(source, borderLeft, borderTop, width + borderLeft, height + borderTop, 0, 0, width,
        height, Color.BLACK, null);

    ImageIO.write(img, "png", file);
  }

}
