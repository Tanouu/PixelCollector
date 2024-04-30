package com.ethan.ai115.pixelcollector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

public class Image {
    public static void main(String[] args) throws Exception {
        String base64Image = "iVBORw0KGgoAAAANSUhEUgAAAV4AAAFeAQAAAADlUEq3AAADHklEQVR4Xu2aS3LiQBBESzGLWXIEjqKjSUfjKDqClywIajKzWrhBDeNZT1aEEep60iJdv2478ud2i9eVD2a4N8O9Ge7NcG//B3wPGW5gS8Tvr/MF61et/moXw0OY33K9Yx0U4Nxm3OUXHsXiaUcMD2BoOa9U9nxZoPopLwsFPst32iIMf4Sl7LwiGr/OUB2RCp3xBsN/hfENVE5w56XyWXIb/gTjQ9l92qCzQjRULWeF6I4YPsJcp5aCDxc5DQ/h3W7I5xkhmozNiWUymevffsOvcEXjyj6sfG4+Ccw3nPmo4RGMT2bwfqkuEuowqSGQF8MjWIkcMVHSpJuTTEt56axXGH4LL621PLJbcw0j9TmeDfcJy0RGdvOZeb9TwDaq1UfDI1iUsnutDe+i7IapHdfvwPARvmGLq0mGXi5svCg2k5HKHYjhEUwRkd3TLdoWFxTXWRHb5q0vBYafax3cDMqicuMsqGqptM5VlOEDfOeZlLSkpDqhCj6qkRB7ODz6nd2Gn2AKDC0ryRss8XOVT0lueATvGXwFuaT6cJCKOTUEGn4LVwbfeb5SQ8umSab1FERqBazhAaxTqApRyd3KJHSOMr3P8AFOVkQoW9aP0Rpv6s7wezhbbFYfrqCkUfXlVWfDO9zcPCQI2pmFscpkmeExfGcic10NmD4kOVyIzVUh2mZBwwc4K7snFMas7H4sJuG8LLo3fIDZh6llEH7oDNWjzl4Ad1s8wx0sd6uIbbs2a5IJNufkJGN4DNf01y5QVpuNqeI2WB+r3xgewGofOo2Pqoj1KCnaxj2c4ffw0npK6yJZhTHqlLRvx4Zf4WBsRpOUB1WqiCX32mW34Q5uxiMDTH86ZmFaKzYpcKlueABLy+C/pEDZguHWATMLIxuN4TcwUzfZgDW0qA+HRhjm+qvOhp/gKzOYJ8updtwehe3ZrfcZfgtTUg2BuMvaiKz4Ycob/gxT5/anCwbllRKztWyHScbwA+ZX6MwayB0IqTub88xGk1vbgRg+wnTSzdmFGzRNf3xUrYX1kazhI/xTM9yb4d4M92a4N8O9/Rv8B4GnO5HFFJUnAAAAAElFTkSuQmCC";
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
        File outputFile = new File("output.png");
        ImageIO.write(img, "png", outputFile);
    }

}
