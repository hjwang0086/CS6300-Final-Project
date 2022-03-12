# JobCompare6300 V1.0 User Manual

**Author**: Hao-Jen Wang

## 1. Introduction

This app consists of 5 main functions, and they are presented in forms of Graphical User Interface:

- `Set Current Job`: store information about current job. There must be only one current job.
- `Add Offer`: store information about offers. There may have multiple offers.
- `Set Weights`: set the weight (importance) for each attribute of jobs. It is used for scoring jobs.
- `Rank Jobs`: list and rank jobs according to their scores. Scores are computed via a weighted sum of job attributes and their corresponeded weights.
- `Compare Jobs`: compare 2 specific jobs by showing their attributes in a table.

Once an user exit the program, all variables will be stored in a local Android SQLite database.

---

## 2. Graphical User Interface

### 2-1. `Main Menu`

- It contains 4 buttons for the transitions of different graphical user interfaces. Pressing one button will introduce user to a specific new UI.
- `Rank Jobs` interface is disabled if no job offers were entered yet.
- `Compare Jobs` interface is not accessible here.

### 2-2. `Set Current Job`

- It contains multiple columns assigned by user input, such as `Title`, `Company`, `Location`, `Cost of Living`, `Yearly Salary`, `Yearly Bonus`, `Retirement Benefits`, `Relocation Stipend`, and `Restricted Stock Unit Award`.
- `Cost of Living` should be expressed as an [index](https://www.expatistan.com/cost-of-living/index/north-america).
- `Retirement Benefits` should be an interger in the range 0-100.
- Clicking `Save and Exit` button will save these information to current job and return to main menu. Saving will be successful only if required columns are filled.
- Clicking `Cancel and Exit` button will ignore the forms and go back.
- If an user had previously saved a job, the second time that the user fills those columns will modify the previous job information instead of adding a new one.

### 2-3. `Add Offers`

- It contains multiple columns assigned by user input, such as `Title`, `Company`, `Location`, `Cost of Living`, `Yearly Salary`, `Yearly Bonus`, `Retirement Benefits`, `Relocation Stipend`, and `Restricted Stock Unit Award`.
- `Cost of Living` should be expressed as an [index](https://www.expatistan.com/cost-of-living/index/north-america).
- `Retirement Benefits` should be an interger in the range 0-100.
- Clicking `Save` button will save these information to a new offer. Saving will be successful only if required columns are filled.
- Clicking `Cancel` button will clear the buffer of user input.
- Clicking `Main Menu` button will return to main menu and clear the buffer of user input automatically.
- Clicking `Compare` button will compare newest saved offer with current job. If there is no current job, it will be disabled.

### 2-4. `Set Weights`

- It contains multiple columns assigned by user input, such as weights of `Yearly Salary`, `Yearly Bonus`, `Retirement Benefits`, `Relocation Stipend`, and `Restricted Stock Unit Award`.
- Clicking `Save and Exit` button will save these information to current job and return to main menu.
- Clicking `Cancel and Exit` button will clear the buffer and return to main menu.

### 2-5. `Rank Jobs`

- It shows a list of offer/jobs sorted by their scores. Exact formula of score is computed as a **weighted** sum of:
  ~~~
  Score = [w1*AYS + w2*AYB + w3*RS + w4*(RPB*AYS/100) + w5*(RUSA/4)] / (w1 + w2 + w3 + w4 + w5)
  ~~~
  
  where:
  - AYS = yearly salary adjusted for cost of living
  - AYB = yearly bonus adjusted for cost of living
  - RBP = retirement benefits percentage
  - RS = relocation stipend
  - RSUA = restricted stock unit award
  - **weights** (w1, w2, w3, w4, w5) are assigned according to `Set Weights`

- Red-colored job indicates the current job, and the remaining indicates the saved offers.
- An user can select 2 jobs to compare. Selected items will be covered by green background color.
- Clicking `Compare` button will compare 2 jobs that user selected. If an user selected not equal to 2 jobs, it will be disabled.
- Clicking `Main Menu` button will return to main menu.

### 2-6. `Compare Jobs`

- It is only triggered only from `Add Offers` or `Rank Jobs` interfaces.
- Two jobs will be shown in a table according to their attributes.
- Clicking `Back` button will return to the previous interface.
- Clicking `Main Menu` button will return to main menu.
