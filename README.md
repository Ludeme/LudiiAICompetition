<img align="right" src="./resources/ludii-logo-64x64.png">

# Ludii AI Competition - CoG 2020

![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
[![twitter](https://img.shields.io/twitter/follow/ludiigames?style=social)](https://twitter.com/intent/follow?screen_name=ludiigames)

## News
- 21 February 2020: This repository made public.

To stay up-to-date with any new announcements about Ludii or the Ludii AI competition, keep an eye out on:
1. Our twitter: https://twitter.com/ludiigames
2. Our forums: https://ludii.games/forums/forumdisplay.php?fid=19

---

## Important Notes on Ludii API Backwards Compatibility

This repository, as well as the [Ludii Example AI repository](https://github.com/Ludeme/LudiiExampleAI),
are written for the latest public pre-release of Ludii available at the time of this writing: Ludii 0.6.0.
At this point, **we cannot guarantee that the API provided by Ludii in future versions will be fully backwards
compatible**. We do not expect any drastic changes, and upgrades to future versions should be relatively easy
and only require minor changes, but will likely require more than 0 changes.

From Ludii version 1.0.0 onwards, we aim to preserve backwards compatibility.

---

## Table of Contents
- [Summary](#summary)
- [Important Links](#important-links)
- [Important Dates](#important-dates)
- [Competition Games](#competition-games)
- [Implementing Agents](#implementing-agents)
- [Submitting Agents](#submitting-agents)
- [Competition Rules](#competition-rules)
- [Contact Info](#contact-info)
- [Acknowledgements](#acknowledgements)

---

## Summary
The Ludii AI Competition is a **general game playing competition** focussed on developing agents that can play a wide variety of board, card, dice and tile games. This competition will use Ludii, a recently developed general game system, to provide the necessary games and API. Games will be provided in the Ludii .lud game description format. The current version of Ludii includes over 200 games, with new games being added frequently. Submitted agents will play against all other competition entrants on a selected set of 20 games in a round-robin format. These games will not be named or provided to the agents beforehand. Agents will have a set amount of time, typically a few seconds, to make each move. The agent that achieves the highest average win-rate across all games will win the competition.

## Important Links
- Main Ludii website: https://ludii.games/
- Ludii competition repository: https://github.com/Ludeme/LudiiAICompetition
- Ludii example AI repository: https://github.com/Ludeme/LudiiExampleAI 
- Ludii competition forum: https://ludii.games/forums/forumdisplay.php?fid=19
- IEEE CoG competitions website: http://ieee-cog.org/2020/competitions_conference 

## Important Dates
- 15 May 2020: Submission deadline for Competition Papers at IEEE CoG 2020: http://ieee-cog.org/2020/cfp  (note that papers about entries to this competition are eligible).
- 2 August 2020: Early submission deadline for agents (we will test agents submitted prior to this date and notify you of any technical issues encountered).
- 9 August 2020: Final submission deadline for agents.
- 17 August 2020: Submission deadline for short summary about algorithms / techniques used by the agent.
- 24-27 August 2020: IEEE CoG 2020 + Announcements of results.

## Competition Games
The competition will use a set of 20 different (variants of) games. These will all be implemented in Ludii’s .lud format, and run using Ludii. These may or may not be games already included in public releases of Ludii. The games will not be revealed to any entrants prior to the competition, but will be published -- in their .lud formats -- after the competition. 

For the IEEE CoG 2020 edition of the Ludii AI competition, all games will be guaranteed to be:
- Two-player
- Zero-sum
- Adversarial
- Turn-based
- Sequential
- Deterministic
- Fully observable

These constraints are expected to be relaxed in future editions or tracks of the competition. Note that we may still have asymmetric games, and we may have games with a "Swap rule" (where after the first move, the second player may opt to switch roles and steal the opening move).

## Implementing Agents
All agents are expected to extend the “AI” abstract class provided by Ludii. At this point in time, this means that agents are expected to be implemented in Java. We hope to make a similar Python API available prior to the competition, but cannot currently give any indication of when this will be ready or guarantee that it will be supported by the Ludii AI Competition at IEEE CoG 2020. 

During the competition, agents will have access to a “Forward Model” of the game they are playing at that time. Whenever a new game is started, all agents will get some time to initialise. They will have access to the “Game” object (containing e.g. the rules of the game), and they will be told which role they are expected to play (i.e. Player 1 or Player 2).

Whenever an agent is expected to make a move, it can:
- Observe (a copy of) the current game state.
- Make copies of any game state.
- Query any game state for the list of legal moves in that state.
- Apply a move to a game state, which causes it to transition into the next state.
- Query any game state for information about that state -- such as the player to move in that state, whether or not it is already over (and what the outcome is), etc.
- Return the move that it wishes to make.

This API for agents is similar to that used by the planning tracks of the [General Video Game AI competitions](http://gvgai.net/) in past years.

## Submitting Agents
We require entrants to submit the source code of their agents -- not just compiled agents. This is to enable us to investigate what an agent does if anything suspicious happens. For example, we may want to make sure that an agent does not recognise and give free wins to a friend’s submission. We will not share this source code with third parties, but do encourage entrants to open-source their entries if possible!

To submit an agent, send an email to ludii.games@gmail.com containing:
- A .zip archive containing any required source code for compiling the agent as an attachment.
- Any instructions for compilation if any non-standard steps are required (if compilation steps are extraordinarily difficult and we fail to compile your agent, it will be disqualified -- try to make sure to submit early such that we have time to test!).
- Which class to instantiate for your agent (if your source code includes multiple classes that extend the AI abstract class).
- Names + affiliations of all authors.
- Name of your agent.

## Competition Rules
- 20 games will be selected by the competition organisers, and not revealed to any participants.
- Submitted agents will be required to play each of these games against every other agent, as both the first and second player. This means that every entry will play 40 * (N - 1) matchups, where N denotes the number of submitted entries. Depending on the number of submissions we receive, this process may be run multiple times to give a more robust result.
- The win-rate for each agent across all matchups that it plays will determine its final ranking. Draws count as half a win for each of the two players.
- For each of the 20 games, the competition organisers will pick an amount of thinking time between 1 and 5 seconds. All entries in all matchups using this game are allowed to use this many seconds per move. Agents that fail to return a move, or return an illegal move, within this period will have a random move made for them. 
- Agents will have 10 seconds to initialise themselves between when a new game starts, and when they must make their first move (setup time).
- The process running your agent will have 3GB RAM available.
- All entries must function on Linux.
- Entries are permitted to write files to their current working directory, but these will not be preserved between match-ups (i.e. no learning from game-to-game).

## Contact Info
The preferred way to contact us with any suggestions or questions about the competition is to use the section for competitions on the Ludii forums (https://ludii.games/forums/forumdisplay.php?fid=19). This also enables other interested people to see the responses.

Alternatively, suggestions and questions may be emailed to: ludii.games@gmail.com 

## Acknowledgements

This repository is part of the European Research Council-funded Digital Ludeme Project (ERC Consolidator Grant \#771292), being run by Cameron Browne at Maastricht University's Department of Data Science and Knowledge Engineering. 

<a href="https://erc.europa.eu/"><img src="./resources/LOGO_ERC-FLAG_EU_.jpg" title="Funded by the European Research Council" alt="European Research Council Logo" height="384"></a>
