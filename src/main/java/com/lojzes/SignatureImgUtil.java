package com.lojzes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * desc.
 * <p> // 个人签章util
 *
 * @author liaoyuanyuan@whyun.net.cn
 * @date 2021/12/24 14:24
 **/
public class SignatureImgUtil {

  /**
   * desc.
   * <p>生成个人签章图片png
   *
   * @return void
   * @author liaoyuanyuan@whyun.net.cn
   * @date 2021/12/24 14:25
   **/
  public static void genImg(String name, String imgFilePath) throws IOException {
    // 字体大小
    int fontSize = 300;
    // 字体长度
    int nameCharSize = name.toCharArray().length;
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

    File file = new File(imgFilePath);

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
