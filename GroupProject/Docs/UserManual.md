# JobCompare6300 V1.0 User Manual

## 1. Introduction

This app consists of 4 main functions, and they are presented in forms of Graphical User Interface:

- `Set Current Job`: store information about current job. There should be at most one current job.
- `Add offer`: store information about offers. There may have multiple offers.
- `Set weights`: set the weight (importance) for each attribute of jobs. It is used for job comparison.
- `Rank jobs`: list and rank jobs according to their scores. Scores are computed via linear combinations of job attributes and assigned weights.

Once an user exit the program, all variables will be stored in a database.

---

## 2. Graphical User Interface

### 2-1. `Main menu`

- It contains 4 buttons for the transitions of different UIs. Pressing one button will introduce user to a specific new window.
- Note that `Rank jobs` is enabled only when there are at least 2 saved jobs (either current job or offers).

### 2-2. `Set current Job`

- It contains multiple text views that are assigned by user input.
- Clicking `Save and Exit` button will save these information to current job and return to main menu. Saving will be successful only if required columns are filled.
- Clicking `Cancel and Exit` button will ignore the forms and go back.
- If an user had previously saved a job and exit, the second time that he/she enters this section will be introduced to modify the job instead of adding another job.

### 2-3. `Add offers`

- It contains multiple text views that are assigned by user input.
- Clicking `Save` button will save these information to a new offer. Saving will be successful only if required columns are filled.
- Clicking `Cancel` button will clear all user inputs.
- Clicking `Main Menu` button will return to main menu.
- Clicking `Compare` button will compare current offer with current job.
- If there is no current job, `Compare` button will be disabled.

### 2-4. `Set weight`

- It contains multiple text views that are assigned by user input.
- Clicking `Save and Exit` button will save these information to current job and return to main menu.
- Clicking `Cancel and Exit` button will ignore the forms and go back.

### 2-5. `Rank jobs`

- It shows a list of offer/jobs based sorted by their scores.
- Clicking `Compare` button will compare 2 jobs that user selected.
- An user can select 2 jobs to compare. Selected items will be covered by green background color.
- If selected jobs are not equal to 2, `Compare` will be disabled.
- Clicking `Main Menu` button will return to main menu.

### 2-6. `Compare jobs`

- It is accessible from `Add offers` or `Rank jobs` interfaces.
- Two jobs will be shown in a table according to their attributes.
- Clicking `Back` button will return to the previous interface.
- Clicking `Main Menu` button will return to main menu.
