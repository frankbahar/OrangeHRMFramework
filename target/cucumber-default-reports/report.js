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
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});