package com.ethan.ai115.pixelcollector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

public class Image {
    public static void main(String[] args) throws Exception {
        String base64Image = "iVBORw0KGgoAAAANSUhEUgAAAV4AAAFeAQAAAADlUEq3AAADD0lEQVR4Xu2ZO5YiMQxFxemAcJZQS2FpxdJYSi1hQgIOGt0nAW4wTE88UtAul68reOhnt/nP7WLPbz5Yw6M1PFrDozU82v8BX03mfjY7HO3LfWPmvzU7a/Gr4SnMkx9jiGXf+fnXbWara5ZIwxNYAvtl71sMsbyJipceOsfMGv4IX21/03k7OFv9tGrW8F/gWL7F8+IITFS/07nhguMP8az3POOisXU5rZPobniAJagJPuSecUi5G57BN8vEyHIKjKfmb1DrDT/D0jnCOge9P1lmxHWXnrpr+A2sYhITls32im7tWZUfD9+iu+EH7Nkqh9wkxh112MNTHYE1JNPwDCYHRgFWx2zas1YTyIcWYr3hOezZOGNH7cm+5kbpZcMz+EJGZEDuXcyWWM6QN4xC0/AUljemlkgqhy0XhdKs4Rms3iXnW53aQlxt9fLUoRw3PMBKjCzHKeNEYowm0Kpxzh3H3NfwM3yFyiPukotZU1RoqDCqNw1PYAI5UmH0gjxX41xHubG0NPwCozNhnd2fZ+9iWZUV+U+poOE7HH8jrK2cMofoZJB5ZVlnuIZncJVcjmtOOZbOO84jRrZkz6OTaXiEkXSoIo9Tm3Q+E+tQDb/CRHcMkEvFuvFe/XNG9/ijNDzA6ZuUD0NnDryGwF6UVG94CqfADDSB9xuqjbB+dtGGB1jxrOimtKgqZ6wvJfCp4Tew+r2D35xScps6ZkKerQ2/gV33K0fBVY6JdT6R3R+qNzyDQ1lqCi82ls9cuohy3VdhDc9hNS3xAp2pykqFSTkHkdzX8BRGYBUTCcxWfUFHueqmG57CNHqWOZADGjClJb5wT5oNz+AyFZO6UpaLki3rN2Bo+BWWluGU6OwcNrgyKBet2eCiDY8wIkYBzmLCs3NDpeJcOn+rKQ0PsCh0lqRJhfJLtoRWxbnhT3BQxr8cs/vbpDrlWD9Fw+9hbHUoXRlEmnSaamZYwxOYR3TmzKEZvQsH3kyMqXrDE1gCW1DR72kwdN7XHmIdtuFX+KfW8GgNj9bwaA2P1vBo/wb/AcEK1F2FgwUuAAAAAElFTkSuQmCC";

        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
        File outputFile = new File("output.png");
        ImageIO.write(img, "png", outputFile);
    }

}
