package draggableTests;

import BaseTest.Hooks;
import org.junit.jupiter.api.Test;

public class Constrain_Movement_Test extends Hooks {

    @Test
    void testDraggableConstrainFunc() {
        pages.getHomePage().clickOnWebAutomationLink();


        try {
            wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
