package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GoalsTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Goals(null));
    }

    @Test
    public void constructor_invalidGoals_throwsIllegalArgumentException() {
        String invalidGoals = "";
        assertThrows(IllegalArgumentException.class, () -> new Goals(invalidGoals));
    }

    @Test
    public void isValidGoal() {
        // null goal
        assertThrows(NullPointerException.class, () -> Goals.isValidGoals(null));

        // invalid goals
        assertFalse(Goals.isValidGoals("")); // empty string
        assertFalse(Goals.isValidGoals(" ")); // spaces only

        // valid goals
        assertTrue(Goals.isValidGoals("Get fitter"));
        assertTrue(Goals.isValidGoals("G")); // one character
        assertTrue(Goals.isValidGoals("Get fitter; Learn more techniques; Gain muscle mass")); // long goal
    }

    @Test
    public void equals() {
        Goals goals = new Goals("Valid Goal");

        // same values -> returns true
        assertTrue(goals.equals(new Goals("Valid Goal")));

        // same object -> returns true
        assertTrue(goals.equals(goals));

        // null -> returns false
        assertFalse(goals.equals(null));

        // different types -> returns false
        assertFalse(goals.equals(5.0f));

        // different values -> returns false
        assertFalse(goals.equals(new Goals("Other Valid Goal")));
    }
}
