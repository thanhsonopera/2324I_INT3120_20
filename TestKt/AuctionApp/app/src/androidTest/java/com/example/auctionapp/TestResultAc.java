package com.example.auctionapp;


import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;


import static androidx.test.espresso.matcher.ViewMatchers.withId;


import com.example.auctionapp.Activity.HomePage;


public class TestResultAc {

    //    @Rule
//    public IntentsTestRule<ResultAuction> activityRule = new IntentsTestRule<>(ResultAuction.class);
    @Rule
    public ActivityTestRule<HomePage> activityRule = new ActivityTestRule<>(HomePage.class);

    @Test
    public void ScrollRecycleViewtTest1() {
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(2));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(10));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(2));
    }

    @Test
    public void ScrollRecycleViewTest2() {
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(10));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(2));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(7));
    }

    @Test
    public void ScrollRecycleViewTest3() {
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(10));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(2));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(7));
    }

    @Test
    public void ScrollRecycleViewTest4() {
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(2));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(7));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(10));
    }

    @Test
    public void ScrollRecycleViewTest5() {
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(1));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(2));
        onView(withId(R.id.rvHome))
                .perform(RecyclerViewActions.scrollToPosition(3));
    }

}