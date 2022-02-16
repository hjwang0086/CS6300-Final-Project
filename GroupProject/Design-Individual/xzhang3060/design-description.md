1. When the app is started, the user is presented with the main menu, which allows the
user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison
settings, or (4) compare job offers (disabled if no job offers were entered yet1).

-Operations in User class can handle these function, setJob(), addOffer(), setComparision() and compareOffer(). UI will be handled by GUI and not shown in design.

2. When choosing to enter current job details, a user will:
a. Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:
i. Title
ii. Company
iii. Location (entered as city and state)
iv. Cost of living in the location (expressed as an index)
v. Yearly salary
vi. Yearly bonus
vii. Retirement benefits (as percentage matched) (Given as Integer 0-100)
viii. Relocation stipend
ix. Restricted stock unit award (expressed as a lump sum vested over 4
years)

-User has Job as an attribute, he/she can set his/her job detail. If the job is not empty, user will not be allowed to enter job.

b. Be able to either save the job details or cancel and exit without saving, returning
in both cases to the main menu.

-This will be handled by login inside the program and GUI.

3. When choosing to enter job offers, a user will:
a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.

-User has offerList(list of Job entity) as an attribute, he/she can set his/her offer detail using addOffer(). User interface will handled by GUI.

b. Be able to either save the job offer details or cancel.

-This will be handled by login inside the program and GUI.

c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the
offer (if they saved it) with the current job details (if present).

-User has operation compareOffer() and addOffer().



4. When adjusting the comparison settings, the user can assign integer weights to:
a. Yearly salary
b. Yearly bonus
c. Retirement benefits
d. Relocation stipend
e. Restricted stock unit award
If no weights are assigned, all factors are considered equal.
5. When choosing to compare job offers, a user will:
a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

-User has an attribute Comparison, and operation setComparison() can be used to handle.

b. Select two jobs to compare and trigger the comparison.

-User has operation compareOffer(), GUI will use to trigger.

c. Be shown a table comparing the two jobs, displaying, for each job:
i. Title
ii. Company
iii. Location
iv. Yearly salary adjusted for cost of living
v. Yearly bonus adjusted for cost of living
vi. Retirement benefits
vii. Relocation stipend
viii. Restricted stock unit award

-This will be handle using the operation compareOffer()

d. Be offered to perform another comparison or go back to the main menu.

-This will be handle by logic in program and GUI.

6. When ranking jobs, a job’s score is computed as the weighted sum of:
AYS + AYB + RS + (RPB * AYS / 100) + (RSUA / 4)
where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
RBP = retirement benefits percentage
RS = relocation stipend
RSUA = restricted stock unit award
The rationale for the RSUA subformula is:
a. value of a restricted stock unit award vests over 4 years

-User has operation called rank() which can rank offers, and this will be used as the logic inside of rank()

b. average value of the restricted stock unit award per year (RSUA / 4)

-User has operation called rank() which can rank offers, and this will be used as the logic inside of rank()