package ru.netology.page.object.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.page.object.data.DataHelper;
import ru.netology.page.object.data.SQLHelper;
import ru.netology.page.object.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.page.object.data.SQLHelper.cleanDatabase;

public class DeadlineSQLTest {
    @AfterAll
    static void teardown() {
        cleanDatabase();
    }

    @Test
    void successfulLoginToYourPersonalAccount() {
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        var dashboardPage = verificationPage.validVerify(verificationCode);
    }
}
