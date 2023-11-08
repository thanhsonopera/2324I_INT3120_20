package com.example.auctionapp;


import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;


import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import com.example.auctionapp.Activity.ResultAuction;
import com.example.auctionapp.Activity.ResultTimeMore;

public class ItemClick {
    @Rule
    public IntentsTestRule<ResultAuction> activityRule = new IntentsTestRule<>(ResultAuction.class);

    @Test
    public void ClickItemOnRecyclerViewTest1() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest2() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest3() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest4() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest5() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest6() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(10,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest7() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(5,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    @Test
    public void ClickItemOnRecyclerViewTest8() {

        onView(ViewMatchers.withId(R.id.rvResult))
                .perform(RecyclerViewActions.actionOnItemAtPosition(8,
                        actionWithAssertions(clickChildViewWithId(R.id.see_more))));

        intended(hasComponent(ResultTimeMore.class.getName()));

    }
    private static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View childView = view.findViewById(id);
                childView.performClick();
            }
        };
    }
}
