package ru.stqa.pft.addreessbook.tests;

        import org.testng.annotations.Test;

public class DeleteContact extends TestBase {


    @Test
    public void deleteContact() {

        app.getNaviationHelper().gotoHomepage();
        app.getContactHelper().selectDeletedContact();
        app.getContactHelper().deleteButton();
        app.getContactHelper().okDialogDeletionButton();
    }

}
