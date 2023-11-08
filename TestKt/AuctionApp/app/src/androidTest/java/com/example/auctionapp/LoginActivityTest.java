package com.example.auctionapp;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import com.example.auctionapp.Activity.Login;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<Login> activityScenarioRule = new ActivityScenarioRule<>(Login.class);
    @Rule
    public ActivityTestRule<Login> mActivityRule = new ActivityTestRule<>(
            Login.class);
    private Login mActivity = null;

    @Before
    public void setActivity() {
        mActivity = mActivityRule.getActivity();
    }
    @Test
    public void testFillLoginUserName() {
        String username = "hello";

        onView(withId(R.id.account))
                .perform(clearText())
                .perform(typeText(username))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.account))
                .check(matches(withText(username)));

    }
    @Test
    public void testFillLoginPassword() {
        String password = "xinchao";

        onView(withId(R.id.password))
                .perform(clearText())
                .perform(typeText(password))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.password))
                .check(matches(withText(password)));

    }
    @Test
    public void testClickRegister() {
        onView(withId(R.id.create)).perform(click());
        onView(withId(R.id.registerActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.registerActivity)).perform(pressBack());


    }
    @Test
    public void testClickSubmit() {
        onView(withId(R.id.submit)).perform(click());
        onView(withText("You need fill your account")).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testClickSubmitOnFillAccount() {
        String username = "helloword";
        onView(withId(R.id.account))
                .perform(clearText())
                .perform(typeText(username))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withText("You need fill your password")).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
    @Test
    public void testClickSubmitOk() {
        String username = "helloword";
        String password = "helloword";
        onView(withId(R.id.account))
                .perform(clearText())
                .perform(typeText(username))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.password))
                .perform(clearText())
                .perform(typeText(password))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()));
    }
    @Test
    public void testAutoCompleteTextView() {

        onView(withId(R.id.account))
                .perform(typeText("banban"), closeSoftKeyboard());

        onView(withText("banban1"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        onView(withText("banban2"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}