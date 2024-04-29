package com.ethan.ai115.pixelcollector.service.impl;

import dev.samstevens.totp.code.*;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Service
public class TwoFactorAuthenticationServiceImpl {

    private final SecretGenerator secretGenerator = new DefaultSecretGenerator();
    private final TimeProvider timeProvider = new SystemTimeProvider();
    private final CodeGenerator codeGenerator = new DefaultCodeGenerator();
    private final CodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);

    public String generateSecretKey() {
        return secretGenerator.generate();
    }

    public String getUriForImage(String secretKey, String username) throws QrGenerationException {
        QrData data = new QrData.Builder()
                .label(username)
                .secret(secretKey)
                .issuer("PixelCollector")
                .algorithm(HashingAlgorithm.SHA1)
                .digits(6)
                .period(30)
                .build();

        QrGenerator qrGenerator = new ZxingPngQrGenerator();
        byte[] qrImage = qrGenerator.generate(data);
        return Base64.getEncoder().encodeToString(qrImage);
    }

    public boolean validateCode(String secretKey, String code) {
        // Convertir la clé secrète en base32 car la bibliothèque s'attend à ce format.
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);

        // Convertir le tableau de bytes en une chaîne de caractères en base32
        String secretKeyDecoded = base32.encodeAsString(bytes);

        // Valider le code
        return verifier.isValidCode(secretKeyDecoded, code);
    }
}


