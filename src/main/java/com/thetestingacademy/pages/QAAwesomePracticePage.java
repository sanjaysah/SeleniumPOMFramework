package com.thetestingacademy.pages;

import com.thetestingacademy.base.BasePage;
import org.openqa.selenium.By;

public class QAAwesomePracticePage extends BasePage {

    private By dropdownContinents = By.id("continents");

    //Page actions
    public QAAwesomePracticePage selectContinent(String text){
        selectDropdownByText(dropdownContinents,text);
        return this;
    }
}
