# Design Description

1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).

    ~~~~
    At the initial step, the MainMenu is called. It shall able to call APIs including:
    (1)EnterOrEditJobDetails, (2) EnterJobOffers, (3) AdjustCompareSettings, and (4) CompareJobOffers.

    Since they are only called by MainMenu and are mostly requiring information such as current job or offers, 
    they can be inherited by the superclass named Entry. The attributes includes the currentJob, the offers 
    (a list of Job), and various weights used to compute the value of a job. 
    The detailed calculation of job scores is defined in getJobScore(). 
    The operation returnMainMenu() is shared among 4 specific APIs and is used to return to the main menu.

    As for CompareJobOffers, the operation isEnabled() will return true if (1) offers has at least two elements, 
    or if (2) currentJob is not null and offers has at least one element.
    ~~~~

2. When choosing to enter current job details, a user will:
    * a. Be shown a user interface to enter (if it is the first time) or edit all of the details of
their current job, which consist of:
        * i. Title
        * ii. Company
        * iii. Location (entered as city and state)
        * iv. Cost of living in the location (expressed as an index)
        * v. Yearly salary
        * vi. Yearly bonus
        * vii. Retirement benefits (as percentage matched) (Given as Integer 0-100)
        * viii. Relocation stipend
        * ix. Restricted stock unit award (expressed as a lump sum vested over 4 years)

    ~~~~
    Since the current job is used in the other part of the requirement (such as EnterJobOffers and CompareJobOffers), 
    I define the class Job to be the data structure that contains information including title, company, etc.
    Then, the superclass Entry will store currentJob as an attribute. 
    It is an aggregation relationship as shown by the edge connection.

    To enter or edit the details of current job, the operation enterOrEditJob() enables to enter a job 
    if isFirstTime is true or to edit a job if otherwise. 
    After enter or edit a job, the attribute tempJob will be modified and is used as a buffer variable.
    ~~~~

    * b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

    ~~~~
    The operations saveJob() and cancelJob() do the tasks. saveJob() will set the currentJob to be the value
    of tempJob and make isFirstTime to be false. cancelJob() will clear the variable tempJob. 
    Both operations will automatically call the function returnMainMenu() in the end to return to MainMenu.
    ~~~~

3. When choosing to enter job offers, a user will:
    * a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.

    ~~~~
    Like the technique in EnterOrEditJobDetails, the variable tempOffer is used as a buffer. 
    When the operation enterOffer() is called, tempOffer will be assigned to the value the user entered.
    ~~~~

    * b. Be able to either save the job offer details or cancel.

    ~~~~
    The operations saveOffer() and cancelOffer() do the tasks.
    saveOffer() will append tempOffer to the variable offers, whereas cancelOffer() clear the buffer tempOffer.
    ~~~~

    * c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

    ~~~~
    To enter another offer, simply call enterOffer() again. To return to the main menu, call the inherited operation returnMainMenu().

    To compare the offer, we can call compare() operation, where the first parameter is the saved offer,
    and the second parameter is the current job. 
    The return value is true if the saved offer has a higher score, and false otherwise. 
    The score calculations are based on getJobScore() defined in the superclass Entry.
    ~~~~

4. When adjusting the comparison settings, the user can assign integer weights to:
    * a. Yearly salary
    * b. Yearly bonus
    * c. Retirement benefits
    * d. Relocation stipend
    * e. Restricted stock unit award
    * If no weights are assigned, all factors are considered equal.

    ~~~~
    In the class AdjustCompareSettings, the operation setWeights do this task. 
    It has 5 input arguments and will modify the Weight attributes which were already defined in the 
    superclass Entry. All weights are set to be 1 initially.
    ~~~~

5. When choosing to compare job offers, a user will:
    * a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst 
    (see below for details), and including the current job (if present), clearly indicated.

    ~~~~
    In the class CompareJobOffers, the operation displayRank() will do this task. It refers the attributes 
    currentJob and offers. The ranking algorithm is implemented by calculating getJobScore() for each offers 
    and currentJob and sorting the scores. Outputs are extracted from attributes title and company of Job objects.
    ~~~~

    * b. Select two jobs to compare and trigger the comparison.

    ~~~~
    The operation compare() do this task. If the first Job has a higher score than the second, it will return 
    true, and vice versa. The score calculations are based on getJobScore() defined in the superclass Entry. 
    This function will also refer the private attributes weights in order to make comparison.
    ~~~~

    * c. Be shown a table comparing the two jobs, displaying, for each job:
        * i. Title
        * ii. Company
        * iii. Location
        * iv. Yearly salary adjusted for cost of living
        * v. Yearly bonus adjusted for cost of living
        * vi. Retirement benefits
        * vii. Relocation stipend
        * viii. Restricted stock unit award

    ~~~~
    The operation displayCompare() do this task. Each attributes are stored as members of Job.
    ~~~~

    * d. Be offered to perform another comparison or go back to the main menu.

    ~~~~
    To perform another comparison, just call compare() or displayCompare() again according to the requirement. 
    To go back to the main menu, call returnMainMenu().
    ~~~~

6. When ranking jobs, a job’s score is computed as the weighted sum of:

    AYS + AYB + RS + (RPB * AYS / 100) + (RSUA / 4)

    where:
    AYS = yearly salary adjusted for cost of living
    AYB = yearly bonus adjusted for cost of living
    RBP = retirement benefits percentage
    RS = relocation stipend
    RSUA = restricted stock unit award

    The rationale for the RSUA subformula is:
    * a. value of a restricted stock unit award vests over 4 years
    * b. average value of the restricted stock unit award per year (RSUA / 4)
    For example, if the weights are 2 for the yearly salary, 2 for relocation stipend, and 1 for all other factors, the score would be computed as:

    2/7 * AYS + 1/7 * AYB + 2/7 * RS + 1/7 * (RPB * AYS / 100) + 1/7 * (RSUA / 4)

    ~~~~
    The calculation will be implemented inside the operation getJobScore(). 
    The weights can be referred from the attributes.
    ~~~~

7. The user interface must be intuitive and responsive.

    ~~~~
    This is not represented in my design, as it will be handled entirely within the GUI implementaion.
    ~~~~

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

    ~~~~
    This design only considers a single system scenario, as there is no any further information about devices.
    ~~~~