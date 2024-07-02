package com.navr.junit5.demo.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"com.navr.junit5.demo.pkg1"})
@SelectClasses({com.navr.junit5.demo.pkg2.TestB.class})
@IncludeTags("random")
@SuiteDisplayName("A demo Test Suite")
@Suite
public class MyTestSuite {

}
