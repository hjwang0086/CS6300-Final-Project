# Requirements
When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  
## To realize this requirement, I create the user, currentJob, offer, and compare classes. Then I add  enter, edit operation in the job class, as well setWeights, compareOffer operation in the compare class.
When choosing to enter current job details, a user will:
Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:
Title
Company
Location (entered as city and state)
Cost of living in the location (expressed as an index)
Yearly salary
Yearly bonus
Retirement benefits (as percentage matched) (Given as Integer 0-100)
Relocation stipend
Restricted stock unit award (expressed as a lump sum vested over 4 years)
Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
## To realize this requirement, I add attributes as above and add save,cancel operations in the job class. 
When choosing to enter job offers, a user will:
Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
Be able to either save the job offer details or cancel.
Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
## To realize this requirement, I add attributes as above and add save,cancel operations in the offer class. Then I found that the offer class has the same attribute and operation as the currentJob class. I combine these two classes to one class–job. And I add jobStatus attribute and use enumeration class as its type.
## Beside, I add compareCurrentJob in the compare class and add enterJob operation in the job class.
## I add the mainMenu operation in the user class for the function of return to the main menu.
When adjusting the comparison settings, the user can assign integer weights to:
Yearly salary
Yearly bonus
Retirement benefits
Relocation stipend
Restricted stock unit award
If no weights are assigned, all factors are considered equal.
## To realize this requirement, I add attributes as above  and set the default value to 20 for each attribute in the compare class.
When choosing to compare job offers, a user will:
Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
## To realize this requirement, I added the compareAllJob operation in the compare class, the return type of this operation is List of String, which will display the Title and Company.

Select two jobs to compare and trigger the comparison.

Be shown a table comparing the two jobs, displaying, for each job:
Title
Company
Location 
Yearly salary adjusted for cost of living
Yearly bonus adjusted for cost of living
Retirement benefits
Relocation stipend
Restricted stock unit award
Be offered to perform another comparison or go back to the main menu.
## To realize this requirement, I added the compareTwoJob operation in the compare class. the return type of this operation is Job and display all attribute of each job.

When ranking jobs, a job’s score is computed as the weighted sum of:

AYS + AYB + RS + (RPB * AYS / 100) + (RSUA / 4)

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
RBP = retirement benefits percentage
RS = relocation stipend
RSUA = restricted stock unit award

The rationale for the RSUA subformula is:
value of a restricted stock unit award vests over 4 years
average value of the restricted stock unit award per year (RSUA / 4)

For example, if the weights are 2 for the yearly salary, 2 for relocation stipend, and 1 for all other factors, the score would be computed as:


2/7 * AYS + 1/7 * AYB + 2/7 * RS + 1/7 * (RPB * AYS / 100) + 1/7 * (RSUA / 4)

## This is not represented in my design, as it will be handled entirely within the gui implementation.

The user interface must be intuitive and responsive.
## This is not represented in my design, as it will be handled entirely within the gui implementation.
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
## For simplicity, the user class is not necessary because that no cmmunication or saving between devices is necessary.
