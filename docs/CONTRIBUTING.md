# Contributing Guidelines
The following is a set of prerequisites and guidelines for contributing to the project. These are mostly guidelines, not rules.
Use your best judgment, and feel free to propose changes to this document in a pull request.

## Table Of Contents
1. [Prerequisites](#prerequisites)
	1. [ZenHub](#zenhub)
	2. [Java](#java)
	3. [Gradle](#gradle)
	4. [IDE](#ide)
2. [Workflow](#workflow)
	1. [Opening Issue \[Backlog\]](#opening-issue)
		1. [Description](#description)
		2. [Technical Description](#technical-description)
		3. [References](#references)
		4. [File Attachments](#file-attachments)
		5. [Labels](#labels)
		6. [Assignee](#assignee)
		7. [Issue Dependencies](#issue-dependencies)		
	2. [Issue Approval \[To Do\]](#issue-approval)
	3. [Starting Progress \[In Progress\]](#starting-progress)
		1. [Issue Pick-up](#issue-pick-up)
		2. [Feature Branch](#feature-branch)
		3. [Committing](#committing)
	4. [Reviewing Issue \[Review\]](#reviewing-issue)
		1. [Preparing for Review](#preparing-for-review)
		2. [Reviewing](#reviewing)
		3. [Review Unsuccessful](#review-unsuccessful)
		4. [Review Successful](#review-successful)
	5. [Resolving Issue \[Done\]](#resolving-issue)
		1. [Merging Feature Branch](#merging-feature-branch)
		2. [Completing Issue](#completing-issue)


## Prerequisites
This section will cover the concepts and tools required to be able to contribute to the project. Configuration suggestions
to improve work efficiency can be found in the [README](README.md) file.

### ZenHub
The project utilises **ZenHub** GitHub plugin to manage its issues and workflow. Contributors can gain access to it
by either opening its [web application](https://app.zenhub.com) or installing a [browser extension](https://www.zenhub.com/extension) 
and accessing it via GitHub directly.

### Java
The project uses [Java Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and it is required in order to contribute.

### Gradle
The project utilises **Gradle** build tool to achieve IDE independence and manage project's dependencies. Thankfully, it does not need to be explicitly installed, 
as this is taken care by simply running provided gradle wrapper scripts within the project (*gradlew* for Linux|Mac users and *gradlew.bat* for Windows users).
The script will download and setup gradle upon its first run and also build the project.

### IDE
To work on the project you'll need any Java IDE. Although any of them are fine, [Intellij IDEA](https://www.jetbrains.com/idea/download) is strongly recommended due to its
outstanding integration with other development tools including Gradle, SpringBoot, Git and GitHub. Its **Community Edition** is free and if you have access to
an academic e-mail, a free one-year licence to **Ultimate Edition** can be obtained [here](https://www.jetbrains.com/shop/eform/students).


## Workflow
The project employs the workflow stages described bellow. These should be followed by all contributors.

### Opening Issue
Firstly, the issue is created/opened indicating what needs to be done.
A starting point for a new issue is the **"Backlog"** pipeline where the issue is automatically assigned
and should stay there until moved to another pipeline by an administrator.
The components of an issue are described bellow.
#### Description 
This section is supposed to contain a general overview of the issue, outlining everything needed to grasp the general concept.
#### Technical Description
The **"Technical Description"** section is meant for describing any technical details of the issue.
This includes any relevant code snippets, implementation requirements or suggestions and etc.
#### References
If there're any useful internet pages relating to the issue, they should be added in the unordered list 
under the **"References"** section. These could include pages such as forum posts providing implementation suggestions or
pages containing some theoretical reading regarding the concepts needed for the issue.
#### File Attachments
If the there are any useful files related to the issue such as design snippets or confirmed text data,
they can also be attached to the issue.
#### Labels
A selection of labels is provided to better classify the issue. It is up to the creator of the issue to decide which ones apply.
Most important and most frequently used are the **"Front-end"** and **"Back-end"** labels indicating the general type of the issue.
#### Assignee
If the creator of the issue prefers to work on it by oneself, the issue can be reserved by assigning it to oneself upon creation.
Otherwise, the issue should be left unassigned, indication that it can be picked up by anyone.
#### Issue Dependencies
If the issue is dependant on any other issues, all of those should be added as issue dependencies.
This can be done via **"+ add dependency"** button visible after creating the issue.

### Issue Approval
Once the issue is created and appears in the **Backlog** pipeline, an administrator has to review it and approve it. Once approved,
the issue will be moved to the **"To Do"** pipeline, at which point it can be picked up and worked on.

### Starting Progress
Any issue in the **"To Do"** pipeline can be picked up and worked on by anyone with few exceptions:
* Issues already assigned to someone are reserved to that particular assignee.
* Issues with dependencies cannot be started until all its dependencies are resolved.

#### Issue Pick-up
Once you've found an issue you like in the **"To Do"** pipeline, assign it to yourself (if not already assigned) and move the issue to 
**"In Progress"** pipeline.
#### Feature Branch
When the issue is all setup on ZenHub's board, the feature branch needs to be created, branching off of latest **develop** or if the issue
has an epic link, the respective **epic** branch.
The feature branch should be named following this structure: "feature/{initials}\_{issue_id}\_{summary}". Note that since git 
branches doesn't allow space characters, underscores are used instead.
> e.g. `feature/MP_MySampleProject-1_An_Example_Issue_Summary`

The placeholders within the above template are explained below:
* {initials}: Assignee's initials. 
	> e.g. For **John Goodman**, {initials} = `JG`
* {issue_id}: The unique id generated by GitHub for a given issue. It's usually formatted as {project_name}-{issue_index}.
	> e.g. For issue **#1** of the project named **MySampleProject**, {issue_id} = `MySampleProject-1`
* {summary}: A brief description of the issue. It can (but doesn't have to be) simply the title of the issue.
	> e.g. {summary} = `Sample_Issue_Title`

#### Committing
All contributors are only allowed to commit to their feature branch for code safety. Committing itself, however, is encouraged
to be done as often as reasonably possible, providing a brief description of the sub-task done within the commit. Commit message
must be structures as `[{issue_id}] {commit_summary}` where placeholders are:
* {issue_id}: The issue's ID described in the previous section.
	> e.g. {issue_id} = `MySampleProject-1`
* {commit_summary}: An optional (but preferred) summary describing the work done in the commit.
	> e.g. {commit_summary} = `Initial draft of the feature implemented`

This transitions to a commit message that looks something like the example bellow:
> `[MySampleProject-1] Initial draft of the feature implemented`


### Reviewing Issue
Once the development of the issue is completed, the issue must be reviewed before it can be fully resolved.
The bellow sub-sections outline the general process of getting the issue reviewed.
#### Preparing for Review
After finishing one's work on the issue, the developer must create a **Pull Request** of the issue's feature branch to be
pulled into develop or, if the issue has a liked epic issue, the respective epic branch. There are few thing that needs to be done
before submitting a **Pull Request** and are described bellow:
* The target branch should be either develop or a respective epic branch if the ticket has an epic link.
* The issue must be linked with the pull request via ZenHub's **"Connect with an issue"** button.
* The title of the pull request must include the issue id
	> e.g. `MySampleProject-1`
* *(Optionally)* An assignee can be set if you need a particular person to review your code changes. Otherwise leave it unassigned
	to be picked up by anyone.
		
After being created, the pull request will automatically appear in the **"Review"** pipeline.

#### Reviewing
#### Review Unsuccessful
#### Review Successful

### Resolving Issue
#### Merging Feature Branch
#### Completing Issue