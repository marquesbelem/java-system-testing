package pages;

import support.DriverQA;

class BasePage {
    final DriverQA driver;

    BasePage(DriverQA stepDriver) {
        this.driver = stepDriver;
    }
}
