# Requirements

## Requirement 1

> When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).

We make `User` class for a user. The `CompareOfferService` will implicitly introduce the user to the main menu and wait for user inputs. (1) To enter or edit current job details, `User` has an attribute `currentJob` and an operation `setCurrentJob(Job)`. A user can enter a new job if the `isCurrentJobEmpty()` indicator is true, or edit a job if otherwise. (2) To enter job offers, `User` has an attribute `offerList` and an operation `addOffer(Job)`. Since current job and offers belong to the same category, they are defined by the class `Job`. One user may have multiple offers, so the aggregation relationship between `User` and `Job` is one-to-many. (3) To adjust the comparison setting, `User` has the operation `setWeight(Weight)` and can modify its attribute `factorWeight`. (4) To compare job offer, `User` has operations `compareOffer(Job, Job)`, `showOffer()`, and `rank()`. If `isOfferListEmpty()` indicator is true, these operations will be disabled.

## Requirement 2

> When choosing to enter current job details, a user will: a. Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job
> b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

We make `Job` class which is the parent class of current job. The Job class has 9 attributes as requested above. The user interface will show several input blocks to get all the information about the current job. In the bottom, there are two buttons, `save` and `cancel`. The `cancel` button will return without any action while the ‘save’ button will continue the following operation. If the current job is null, the system will create a new current job and save all the details, or else the system will update the latest information to the current job.

Finally, the interface will return to the main menu interface automatically.

## Requirement 3

> When choosing to enter job offers, a user will: a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.

The user interface will show several empty blocks to allow the user to write in the details of the offer and the blocks will correspond to what attributes in `Job` Class. The action of enter offer will be handled in `CompareOfferService` as its operation `enterOfferActivity()`.

> b. Be able to either save the job offer details or cancel.

In the same user interface that user can input the detail of the offer, a save bottom and a cancel will be placed to either call function `addOffer(Job)` to save the `Job` that based on the user input in the previous step in `offerList` or it will clear what user writes.  The user chooses to save the offer, the offer will be added into attribute `offerList[Job]` as an element under the `User` class.

> c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

The option of entering another offer, returning to the menu, and comparing offers will be shown as bottoms in the GUI. And each of the options will be handled by `enterOfferActivity()` `returnMainActivity()` and `compareOfferActivity` in `CompareOfferActivity`.

## Requirement 4

> When adjusting the comparison settings, the user can assign integer weights
> If no weights are assigned, all factors are considered equal.

Class `Weight` is added to the class diagram to group all the weights together. A user can have a single weight object, which is shown as a class member `factorWeight` in `User`. A `Weight` object will be initialized with all weights set to 1, since all factors are considered equal.

## Requirement 5

> When choosing to compare job offers, a user will: a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
> b. Select two jobs to compare and trigger the comparison.
> c. Be shown a table comparing the two jobs, displaying, for each job
> d. Be offered to perform another comparison or go back to the main menu.

The GUI for choosing to compare job offers is handled in `compareOfferActivity()` in `CompareOfferService`. Job offers and the current job are ranked by `rank()` method in `User`. Upon receiving the user action, the two chosen jobs will be set as arguments in `compareOffer()` method. Return of the `compareOffer()` method triggers `CompareOfferService` for displaying the table by comparing the two jobs. Offering to perform another comparison or going back to the main menu is handled in `CompareOfferSerivce` for GUI transition.

## Requirement 6

> When ranking jobs, a job’s score is computed as the weighted sum

The formula of computing the weighted sum is implemented in `rank()` method in `User`, which uses the `User` class member `factorWeight` to retrieve the necessary weights.

## Requirement 7

> The user interface must be intuitive and responsive.

This requirement cannot be represented in the class diagram, since it is handled in GUI implementation.

## Requirement 8

> For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

The class diagram was created upon this requirement, where a single system runs the app. Interaction between the classes assumed everything can be communicated without extra help.