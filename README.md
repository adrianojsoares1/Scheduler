## Documentation
#### Description

a. Purpose: The purpose of this application is simulate multiple algorithims for blocking.

b. Implementation: The language we had used for this project was Java. The structure was Process, Block, RNG.
* **Process:** Looks at Processes which looks at the multiple processes (1, 2, 3, 4),  process run time, the time the process time finishes using the RNG class.
* **Block:** Determines the block type, block length, and the block resource.
* **RNG:** Has the three methods to determine the random number manipulation.

c. Class and Methods:
* Classes:
 * Resource
 * Scheduler
 * Block
 * Process
* Methods or Functions used:
 * A lot
d. Description (Process Set Generation and Core of Scheduling Algorithm)
* **Process Set Generation:** A Process is made and creates resource A, B, or C. A number within the code is randomly generated out of 100 in order to determine will process will be created.
* Based on Percent Distribution:
 * There is a 50% chance Process I will be created.
 * There is a 30% chance Process II will be created.
 * There is a 27% chance Process III will be created.
 * There is a 3% chance Process IV will be created.
* An initial process randomly generates a number from 3 to 8. A for loop is used which creates “i” amount of processes according to the number randomly generated. These processes are created within an array list, which retrieves the finish time.
* The rest of the processes are added up, and once the number created by the rest of the processes is greater than 25000, creation of processes stops.

* **Core of Scheduling Algorithm:**

e. Description (Scheduling Algorithms Implemented)
* Scheduling Algorithms:

f. Description (User Interface, Results of a Scheduling Run, How Results are Compared )
* User Interface:
* Scheduling Run
* How the Results of Different Schedules are Compared

 #### Change History
 * Change in Design: Made the code shorter and more efficient, optimization increased as more code is pushed and shortened.
 * No real issues encountered, group as a whole worked on code together, any issues were resolved immediately.
 * N/A

 #### Division of Responsibility
 **Josh**
 * RNG Class
 * Workset Generation
 * Block Class
 * Documentation
 * Presentation
 * Useful discussion
 * Markdown

 **Davis**
 * Shorten Josh’s code
 * Resource Class
 * RNG Class
 * Process Class
 * Resource Class
 * Workset Generation
 * Useful Discussion

 **Sarvesh**
 * Presentation
 * Documentation
 * Useful Discussion
 * Markdown

 **Adriano**
 * Created and Managed Github Repository
 * Resource Class
 * Process Class
 * Scheduler Classes
 * Queue Class and Interface
 * Worked to support every other member
