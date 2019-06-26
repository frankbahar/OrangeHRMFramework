$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployee.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged in into OrangeHrm",
  "keyword": "Given "
});
formatter.match({
  "location": "AddEmployeeSteps.i_logged_in_into_OrangeHrm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on PIM link",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_PIM_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Add Employee details",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_Add_Employee_details()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Employee and Create Login Details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@temp"
    }
  ]
});
formatter.step({
  "name": "I provide employee details from \"EmployeeDetails\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_provide_employee_details(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Create Login Details",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_Create_Login_Details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I provide all mandatory fields",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_provide_all_mandatory_fields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on save button",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see employee is added successfuly",
  "keyword": "Then "
});
formatter.match({
  "location": "AddEmployeeSteps.i_see_employee_is_added_successfuly()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Values should be different. Actual: 0\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failEquals(Assert.java:185)\r\n\tat org.junit.Assert.assertNotEquals(Assert.java:199)\r\n\tat org.junit.Assert.assertNotEquals(Assert.java:211)\r\n\tat com.Orangehrm.steps.AddEmployeeSteps.i_see_employee_is_added_successfuly(AddEmployeeSteps.java:80)\r\n\tat ✽.I see employee is added successfuly(file:src/test/resources/features/AddEmployee.feature:24)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});