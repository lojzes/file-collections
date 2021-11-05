package com.lojzes.img;

import cn.hutool.core.img.ImgUtil;
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
    //d1(30);
   // d2();
   // d3(30,"爱新觉罗张三丰");
    d3(30,"张丰");
  }

  public static void d2() throws IOException {
    Font font = new Font("楷体", Font.BOLD, 100);
    Color bg = Color.white;
    Color ft = Color.BLACK;
    FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(
        new File("d:\\test.png"));
    ImgUtil.createImage("廖远远", font, bg, ft, fileImageOutputStream);
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
    graphics.fillRect(0,0,width,height);
    // 设置字体
    Font font = new Font("楷体", Font.BOLD, fontSize);
    graphics.setFont(font);
    // 设置字体颜色
    graphics.setColor(Color.black);
    // 写字
    int y = fontSize + fontSize/2;
    graphics.drawString("张三丰",w,y);
    // 释放对象
    graphics.dispose();
    ImageIO.write(bufferedImage, "png", new File("d:\\test.png"));
  }

  public static void d3(int fontSize,String name) throws IOException {
    // 字体长度
    int nameCharSize = name.toCharArray().length;
    // int fontSize = 25;
    // 字体左右 距 画板的距离
    int w = 10;
    if(nameCharSize == 2){
      char[] chars = name.toCharArray();
      name = chars[0] + " " + chars[1];
      nameCharSize = 3;
    }

    int width = fontSize * nameCharSize + w * 2;
    int height = fontSize * 2;

    // 创建BufferedImage 对象
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // 获取画笔
    Graphics2D graphics = bufferedImage.createGraphics();
    // 设置背景色
    graphics.setColor(Color.white);
    // 画一个矩形
    graphics.fillRect(0,0,width,height);
    // 设置字体
    Font font = new Font("楷体", Font.BOLD, fontSize);
    graphics.setFont(font);
    // 设置字体颜色
    graphics.setColor(Color.black);
    // 写字
    int y = fontSize + fontSize/2;
    graphics.drawString(name,w,y);
    // 释放对象
    graphics.dispose();

    File file = new File("d:\\test.png");
    ImageIO.write(bufferedImage, "png", new File("d:\\test.png"));

    BufferedImage source = bufferedImage;

    int borderLeft = 2;
    int borderTop = 6;

    int borderedImageWidth = width + (borderLeft * 2);
    int borderedImageHeight = height + (borderTop * 2);
    BufferedImage img = new BufferedImage(borderedImageWidth, borderedImageHeight, BufferedImage.TYPE_3BYTE_BGR);
    img.createGraphics();
    Graphics2D g = (Graphics2D) img.getGraphics();
    g.setColor(Color.black);
    g.fillRect(0, 0, borderedImageWidth, borderedImageHeight);
    g.drawImage(source, borderLeft, borderTop, width + borderLeft, height + borderTop, 0, 0, width, height, Color.YELLOW, null);

    ImageIO.write(img, "png", file);
  }
}
