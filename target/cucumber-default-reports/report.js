$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login to Orange HRM website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sprint3"
    }
  ]
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
  "name": "I see OrangeHrm logo",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_see_OrangeHrm_logo()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "with invalid credentials I should not be able to login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sprint3"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I enter invalid username and password",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_enter_invalid_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_click_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see error messages is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_see_error_messages_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});