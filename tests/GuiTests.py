#!/usr/bin/env python
# -*- coding: utf-8 -*-

import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

class Tests(unittest.TestCase):
    def setUp(self):
        self.address = 'http://denisenkodenis.ru'
        self.driver = webdriver.Firefox()

    #Check Title for Ru version
    def testTitleRu(self):
        driver = self.driver
        driver.get(self.address)
        elementTitle = WebDriverWait(driver, 10).until(
            EC.title_is(u'Денисенко Денис')
        )
        driver.close()

    #Check Title for En version
    def testTitleEn(self):
        driver = self.driver
        driver.get(self.address)
        elementTitle = WebDriverWait(driver, 10).until(
            EC.title_is(u'Денисенко Денис')
        )
        eButtonEn = driver.find_element(By.XPATH, '//div[@class="block border indent header"]/div/a[@href="#en"]')
        eButtonEn.send_keys(Keys.ENTER)
        elementTitle = WebDriverWait(driver, 10).until(
            EC.title_is(u'Denisenko Denis')
        )
        driver.close()

    #Check contacts
    def testContacts(self):
        driver = self.driver
        driver.get(self.address)
        elementTitle = WebDriverWait(driver, 10).until(
            EC.title_is(u'Денисенко Денис')
        )
        eButtonContacts = driver.find_element(By.XPATH, '//div[@class="block border indent header"]/table/tbody/tr/td[2]/a')
        eButtonContacts.send_keys(Keys.ENTER)
        eButtonMail = WebDriverWait(driver, 10).until(
            EC.element_to_be_clickable((By.ID,'contacts'))
        )
        driver.close()

    #Chock tool tip for contacts
    def testContactsToolTip(self):
        driver = self.driver
        driver.get(self.address)
        elementTitle = WebDriverWait(driver, 10).until(
            EC.title_is(u'Денисенко Денис')
        )
        eButtonContacts = driver.find_element(By.XPATH, '//div[@class="block border indent header"]/table/tbody/tr/td[2]/a')
        eButtonContacts.send_keys(Keys.SPACE)
        eToolTip = driver.find_element(By.XPATH, '//div[@role="tooltip"]')
        driver.close()
                
    def tearDown(self):
        print(self)
        self.driver.close()

if __name__ == "__main__":
    unittest.main()
