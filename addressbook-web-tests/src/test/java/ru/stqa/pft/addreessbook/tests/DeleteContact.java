package ru.stqa.pft.addreessbook.tests;

        import org.testng.annotations.Test;
        import ru.stqa.pft.addreessbook.model.ContactData;

public class DeleteContact extends TestBase {


    @Test
    public void deleteContact() {

        if (!app.getContactHelper().isThereContact()){
            app.getNavigationHelper().goToContactPage();
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test5", "test6", "test7", "1234567", "234567", "1234567", null, null, null,"test135"),true);
        }
        app.getNavigationHelper().gotoHomepage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteButton();
        app.getContactHelper().okDialogDeletionButton();
        app.getNavigationHelper().gotoHomepage();
    }

}
