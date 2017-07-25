package ru.stqa.pft.addreessbook.tests;

        import org.testng.annotations.Test;

public class DeleteContact extends TestBase {


    @Test
    public void deleteContact() {

        app.getNavigationHelper().gotoHomepage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteButton();
        app.getContactHelper().okDialogDeletionButton();
        app.getNavigationHelper().gotoHomepage();
    }

}
