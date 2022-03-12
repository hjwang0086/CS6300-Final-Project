# Test Plan

**Author**: Xinying Jia, Xiaoran Zhang

## 1 Testing Strategy

### 1.1 Overall strategy

This test plan is about project jobs comparing and conducts 4 types of testing, including unit testing, integration testing, system testing and regression testing. The objective of the test plan is to verify the functionality of the app works according to the requirements.

Test cases include editing the current job or adding a new offer to offer list, compare jobs and updating compare weight settings.

All the testing activities will be designed and executed by Team 045.

### 1.2 Test Selection

Black box testing is based on external expectations and is ideal for higher levels of testing like system testing and acceptance testing.

White box testing is based on internal structure, which is best suited for a lower level of testing like unit testing and integration testing.

- Unit test: white-box test
- Integration test: white-box test
- System test: black-box test
- Regression test: black-box test

### 1.3 Adequacy Criterion

Test adequacy criterion is a predicate that is true or false for a pair (program, test suite).

Test cases include structural testing and achieve full coverage of statement, branch, path, and basic conditions which rely on a control-flow graph.

- Statement coverage = number of statements executed)/ (number of statements in the program)
- Branch coverage =number of branches executed)/ (number of branches in the program
- Path coverage = number of paths executed)/ (number of paths in the program
- Basic conditions coverage is defined as "each basic condition must have a True and a False outcome at least once during the execution of the test suite".

Test cases include fault-based testing and error-based testing.

If 40% of test cases failed, suspend testing until the development team fixed all the failed cases.

If all test cases ran and 80% test cases passed, stop testing to next testing.

### 1.4 Bug Tracking

A shared issue sheet will be used to trace bugs and enhancement requests, each line of the sheet represents a bug or enhancement request, and a flag will be used to identify that. This sheet will include Colum that shows Open or Close, priority, find out date, and planned to be solved date. Every group meeting should have a time slot to go over the sheet and check if any delay appears.

For example, when testing engineering finds a failed test, he/she will record it as a bug in the issue list with status as open, given the proper priority, and record finds out date. A software developer should be assigned to solve the issue before the given date.

### 1.5 Technology

Android with testing applications tools and extend JUnit and selenium for functional testing and UI testing.

## 2 Test Cases

| Test Case | Purpose | Steps | Expected Result | Actual Result | pass/fail | Additional Information |
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|Show Job | Show the details of jobs | 1. select the target jobs <br> 2. show the job details | The job details are displayed. | The job details are displayed |  |  |
| Enter Current Job | Edit and save current job details | 1. input the job details <br> 2. save or cancel | The current job information is updated or created | 1. the action is saved <br> 2. the action is cancelled <br> 3. the information is invalid |   |   |
| Add offer | Edit and save a new offer | 1. input the job details <br> 2. save or cancel | A new offer information is created | 1. the action is saved <br> 2. the action is cancelled <br> 3. the information is invalid |  |  |
| Compare Jobs | Compare selected jobs under the weights setting | 1. User select target at least two jobs (current job or offer) <br> 2. Each target job calculated under the compare weight setting (if not set, then use the default setting) <br> 3. Sort the target jobs by the compare score <br> 4. display the job details on the sorted order | The target jobs are shown in a sorted order | 1. target job is invalid <br> 2. the selected is compared and displayed in the sorted way |  |  |
| Set Weights | Update the job comparing weight setting | 1. Edit the latest weight setting <br> 2. save or cancel | The weight setting is updated. | 1. the action is saved <br> 2 the action is cancelled <br> 3. the information is invalid |  |  |

### 2.1 Detailed Test Cases

**Test Case 1**

- Purpose: to test function of edit current job
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Job entered can be found in the database with correct information.
    - The screen goes back to the main menu.
- Actual result:
    - Job entered can be found in the database with correct information.
    - The screen goes back to the main menu.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 2**

- Purpose: to test function of edit current job
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “CANCEL AND EXIT” button to return to main menu
- Expected result:
    - The database has no change.
    - The screen goes back to the main menu.
- Actual result:
    - The database has no change.
    - The screen goes back to the main menu.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 3**

- Purpose: to test function of add offer
- Steps:
    1. Open the app
    2. Click “ADD OFFER” Button
    3. *check 1* app should show add offer screen
    4. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Amazon”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE” button to save data.
- Expected result:
    - The offer details are saved in database.
    - The screen shows a text “Offer has been saved” then turn to a new add job screen
- Actual result:
    - The offer details are saved in database.
    - The screen shows a text “Offer has been saved” then turn to a new add job screen
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 4**

- Purpose: to test function of add offer
- Steps:
    1. Open the app
    2. Click “ADD OFFER” Button
    3. *check 1* app should show add offer screen
    4. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Amazon”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “CLEAR” button.
- Expected result:
    - The database has no change.
    - The screen shows a new add offer screen
- Actual result:
    - The database has no change.
    - The screen shows a new add offer screen
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 5**

- Purpose: to test function of add offer
- Steps:
    1. Open the app
    2. Click “ADD OFFER” Button
    3. *check 1* app should show add offer screen
    4. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Amazon”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “BACK” button to return to main menu
- Expected result:
    - The screen shows the main menu.
- Actual result:
    - The screen shows the main menu.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 6**

- Purpose: to test function of add offer
- Steps:
    1. Open the app
    2. Click “ADD OFFER” Button
    3. *check 1* app should show add offer screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 200000
        - Yearly Bonus: 50000
        - Retirement Benefits: 9000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Amazon”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    6. Click “COMPARE” button to start comparing.
- Expected result:
    - The offer is saved correctly in database.
    - The screen shows a job comparison screen which displays the offer and current job details.
- Actual result:
    - The offer is saved correctly in database.
    - The screen shows a job comparison screen which displays the offer and current job details.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 7**

- Purpose: to test function of add offer
- Steps:
    1. Open the app
    2. Click “ADD OFFER” Button
    3. *check 1* app should show add offer screen
    4. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Amazon”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “COMPARE” button to start comparing.
- Expected result:
    - The offer is saved correctly in database.
    - The screen shows a text ”Please enter current job beforehand” and turn to add job screen.
- Actual result:
    - The offer is saved correctly in database.
    - The screen shows a text ”Please enter current job beforehand” and turn to add job screen.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 8**

- Purpose: to test function of set weights
- Steps:
    1. Open the app
    2. Click “SET WEIGHTS” Button
    3. *check 1* app should show weight settings screen
    4. Set the new offer as following:
        - Yearly Salary: 2
        - Yearly Bonus: 3
        - Retirement Benefits: 0
        - Relocation stipend: 0
        - Restricted Stock Unit Award: 1
    5. Click “SAVE AND EXIT” button.
- Expected result:
    - The settings are updated in database.
    - The screen shows a text "Weights have been updated" then turn to the main menu.
- Actual result:
    - The settings are updated in database.
    - The screen shows a text "Weights have been updated" then turn to the main menu.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 9**

- Purpose: to test function of set weights
- Steps:
    1. Open the app
    2. Click “SET WEIGHTS” Button
    3. *check 1* app should show weight settings screen
    4. Set the new offer as following:
        - Yearly Salary: 2
        - Yearly Bonus: 3
        - Retirement Benefits: 0
        - Relocation stipend: 0
        - Restricted Stock Unit Award: 1
    5. Click “CANCEL AND EXIT” button.
- Expected result:
    - The settings keep default value in database.
    - The screen turn to the main menu.
- Actual result:
    - The settings keep default value in database.
    - The screen turn to the main menu.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 10**

- Purpose: to test function of rank jobs
- Steps:
    1. Open the app
    2. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 200000
        - Yearly Bonus: 50000
        - Retirement Benefits: 9000000
        - Relocation Stipend: 5000
        - RSUA: 200
    3. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Amazon”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    4. Set the new offer as following:
        - Title: “Software Engineer”
        - Company: “Zoom”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 900000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “RANK JOBS” Button
    6. *check 1* app should show job ranking screen as following:
        - Item 0,Software Engineer,Zoom
        - Item 1 Software Engineer, Apple
        - Item 2 Software Engineer,Amazon
    7. Click “MAIN MENU” button.
- Expected result:
    - The screen displays the jobs in the sorted order.
- Actual result:
    - After click “RANK JOBS” button, the app shows job ranking screen as expected.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 11**

- Purpose: to test function of rank jobs
- Steps:
    1. Open the app
    2. Set current job as following:
    3. Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 200000
        - Yearly Bonus: 50000
        - Retirement Benefits: 9000000
        - Relocation Stipend: 5000
        - RSUA: 200
    4. Click “RANK JOBS” Button
- Expected result:
    - The screen should display a text ”Please enter job/offers before ranking” .
- Actual result:
    - The screen displays a text ”Please enter job/offers before ranking”
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 12**

- Purpose: to test function of edit current job with empth input of title
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: 
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Title should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Title should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 13**

- Purpose: to test function of edit current job with empth input of company
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: 
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Company name should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Company name should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 14**

- Purpose: to test function of edit current job with empth input of location
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: 
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Location should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Location should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 15**

- Purpose: to test function of edit current job with empth input of living cost
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Cost of living should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Cost of living should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 16**

- Purpose: to test function of edit current job with empth input of yearly salary
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Yearly salary should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Yearly salary should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 17**

- Purpose: to test function of edit current job with empth input of yearly bonus
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Yearly bonus should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Yearly bonus should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 18**

- Purpose: to test function of edit current job with empth input of retirement benefit
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Retirement benefit should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Retirement benefit should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A


**Test Case 19**

- Purpose: to test function of edit current job with empth input of relocation stipend
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Relocation stipend should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Relocation stipend should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 20**

- Purpose: to test function of edit current job with empth input of restricted stock unit award
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Restricted stock unit award should not be empty”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Restricted stock unit award should not be empty”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 21**

- Purpose: to test function of compare offer under offer has not been saved situation
- Steps:
    1. Open the app
    2. Click “ADD OFFER” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 7000000
        - Relocation Stipend: 5000
        - RSUA: 20
    5. Click “COMPARE” button to return to main menu
- Expected result:
    - Error shows “Please save offer before compare”
    - The screen stay in add offer page.
- Actual result:
    - Error shows “Please save offer before compare”
    - The screen stay in add offer page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 22**

- Purpose: to test function of compare offer under situation that more than 2 offers have been selected.
- Steps:
    1. Open the app
    2. Enter three offers using “ADD OFFER”
    3. *check 1* Three offers should be saved
    4. Click “RANK JOBS” Button
    5. *check 2* app should show job ranking screen with entered three jobs
    6. Click on all three offers
    7. Click on “COMPARE” button
- Expected result:
    - Error shows “Number of selected jobs should be exactly 2”
    - The screen stay in rank offer page.
- Actual result:
    - Error shows “Number of selected jobs should be exactly 2”
    - The screen stay in rank offer page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 23**

- Purpose: to test function of rank offers under situation that no offer or job is entered
- Steps:
    1. Open the app
    2. Click “RANK JOBS” Button
- Expected result:
    - Error shows “Please enter job/offers before ranking”
    - The screen stay in main menu.
- Actual result:
    - Error shows “Please enter job/offers before ranking”
    - The screen stay in main menu.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 24**

- Purpose: to test function of edit current job with input of retirement benefit smaller than 0
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: -1
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Retirement benefit should be within 0-100”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Retirement benefit should be within 0-100”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 25**

- Purpose: to test function of edit current job with input of retirement benefit larger than 100
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 25
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 101
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Retirement benefit should be within 0-100”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Retirement benefit should be within 0-100”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 26**

- Purpose: to test function of set weight with input of all zero
- Steps:
    1. Open the app
    2. Click “SET WEIGHTS” Button
    3. *check 1* app should show weight settings screen
    4. Set the new weight as following:
        - Yearly Salary: 0
        - Yearly Bonus: 0
        - Retirement Benefits: 0
        - Relocation stipend: 0
        - Restricted Stock Unit Award: 0
    5. Click “SAVE AND EXIT” button.
- Expected result:
    - Error shows “Weight cannot be all zero”
    - The screen stay in set weight page.
- Actual result:
    - Error shows “Weight cannot be all zero”
    - The screen stay in set weight page.
- Pass/Fail: Pass
- Additional Information: N/A

**Test Case 27**

- Purpose: to test function of edit current job with input of cost living equal to 0
- Steps:
    1. Open the app
    2. Click “SET CURRENT JOB” Button
    3. *check 1* app should show current job editing screen
    4. Set current job as following:
        - Title: “Software Engineer”
        - Company: “Apple”
        - Location: “U.S.”
        - Cost of Living: 0
        - Yearly Salary: 100000
        - Yearly Bonus: 50000
        - Retirement Benefits: 25
        - Relocation Stipend: 5000
        - RSUA: 200
    5. Click “SAVE AND EXIT” button to return to main menu
- Expected result:
    - Error shows “Cost of living cannot be 0”
    - The screen stay in edit current job page.
- Actual result:
    - Error shows “Cost of living cannot be 0”
    - The screen stay in edit current job page.
- Pass/Fail: Pass
- Additional Information: N/A
