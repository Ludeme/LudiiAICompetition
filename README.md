<img align="right" src="./resources/ludii-logo-64x64.png">

# Ludii AI Competitions - Computer Games 2022

![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
[![twitter](https://img.shields.io/twitter/follow/ludiigames?style=social)](https://twitter.com/intent/follow?screen_name=ludiigames)


## News
To stay up-to-date with any new announcements about Ludii or the Ludii AI competitions, keep an eye out on:
1. Our twitter: https://twitter.com/ludiigames
2. Our forums: https://ludii.games/forums/forumdisplay.php?fid=26

---

## Table of Contents
- [Summary](#summary)
- [Competition Prizes](#competition-prizes)
- [Participation](#Participation)
- [Important Links](#important-links)
- [Important Dates](#important-dates)
- [Competition Games](#competition-games)
- [Implementing Agents](#implementing-agents)
- [Competition Rules](#competition-rules)
- [Contact Info](#contact-info)
- [Acknowledgements](#acknowledgements)

---

## Summary
The Ludii AI Competitions are **general game playing competitions** focussed on developing agents that can play a wide variety of board, dice and tile games. These competitions will use Ludii, a general game system, to provide the necessary games and API. Games will be provided in the Ludii .lud game description format. The current version (1.3.1) of Ludii includes over 1,000 games, with new games being added frequently. 

Three tracks are proposed:
- Kilothon: Best utility obtained on more than 1,000 games against UCT.
- General Game Playing (GGP): Competiton on games present or not in our library.
- Learning: A set of games are announced months before the actual competition, the agents are invited to learn before competing.

A track is going to run if at least 3 participants take part in it.




## Competition Prizes
- This year, a total prize of **9,900 euros** for the three tracks is funded by the PaRis Artificial Intelligence Research InstitutE (PR[AI]RIE: https://prairie-institute.fr/) thanks to Tristan Cazenave (https://www.lamsade.dauphine.fr/~cazenave/).
- For each track, the 1st place will receive €3,000 and the 2nd place will receive €300. The winners of each track are also going to be invited to write a paper for the first Ludii/DLP conference (happening in 2023).
- Each entrant can enter all three events, but only one agent per event.




## Participation
To participate in any of the tracks, it is necessary to send us an email to ludii.games@gmail.com to register. The required information is your first and last name, the name of your agent and an email to contact you. It would also really be appreciated if you can register to the Ludii forum and give us your login, but this is not required (https://ludii.games/forums/member.php?action=register). As soon as it would be possible for you, a short description (an abstract) of your agent would also be appreciated if shared with us.

On all tracks, agents are going to be run on your own machine. That's why it would also really be appreciated if you are sharing the configuration used to run your agent.
All agents should be implemented thanks to the Ludii Java AI API or the Ludii Python AI API (however if a participant can implement a wrapper to Ludii in any other languages, this is also allowed.). We also encourage entrants (especially winners) to make their source code available after the competition or to share it (privately) with us (this is not a requirement). We will not share this source code with third parties, but do encourage entrants to open-source their entries if possible!

Entrants can not just use direct copies of the open-source Ludii AIs! If they use Ludii AIs as a basis, an abstract description of the agent should be provided and should describe how is different to Ludii AI.





## Important Links
- Main Ludii website: https://ludii.games/
- Ludii competition repository: https://github.com/Ludeme/LudiiAICompetition
- Ludii Java AI repository: https://github.com/Ludeme/LudiiExampleAI 
- Ludii Python AI repository: https://github.com/Ludeme/LudiiPythonAI
- Ludii competition forum: https://ludii.games/forums/forumdisplay.php?fid=26
- Ludii Tutorials: https://ludiitutorials.readthedocs.io/
- Ludii source code repository: https://github.com/Ludeme/Ludii
- A brief tutorial video of how to run an AI agent in Ludii is available at https://www.youtube.com/watch?v=8MhBMEXO8IU (ERIC: TO REDO AND UPDATE)




## Important Dates
- February/March 2022: Learning track games will be announced over February and March.
- February-July 2022: Possibility to run agents on the kilothon track.
- End of July 2022: CG/IJCAI at Vienna, Run of the GGP track and the learning track + announcement of the results.





## Competition Games
The competition will use a set of games. These will all be implemented in Ludii’s .lud format, and run using Ludii. 

For the CG 2022 edition of the Ludii AI competitions, all games will be guaranteed to be:
- Zero-sum
- Adversarial
- Turn-based
- Sequential
- Fully observable




## Implementing Agents
All agents are expected to extend the “AI” abstract class provided by Ludii. This means that agents are expected to be implemented in Java. We also provide a [Ludii Python AI repository](https://github.com/Ludeme/LudiiPythonAI) which shows how a simple Java wrapper to implement this class can be used around a Python-based AI implementation.

During the competition, agents will have access to a “Forward Model” of the game they are playing at that time. They will have access to the “Game” object (containing e.g. the rules of the game), and they will be told which role they are expected to play (i.e. Player 1 or Player 2).

Whenever an agent is expected to make a move, it can:
- Observe (a copy of) the current game state.
- Make copies of any game state.
- Query any game state for the list of legal moves in that state.
- Apply a move to a game state, which causes it to transition into the next state.
- Query any game state for information about that state -- such as the player to move in that state, whether or not it is already over (and what the outcome is), etc.
- Return the move that it wishes to make.




## Competition Rules

### Kilothon track

The kilothon is a new type of AI challenge in which the participants are not competing directly against each other but trying to win the maximum of games against a simple UCT (Upper Confidence Tree) agent. 

For each play, only one minute of ("smart") thinking time is allocated to the challenger. After this time, the agent is playing randomly until the end of the game. The participants can distribute this minute of thinking time as they wish to their agents.
The same rule is applied to UCT and during this minute, 1 second of thinking time per move is used.

All challengers are representing the role of player 1, the UCT agent is representing the role of player 2 and if the game has more than 2 players, all the other roles are played randomly.

On this track, all the games in Ludii following the requirement of (#competition-games) are used (1,058 games on version 3.1.0).

In the rare case of equality between 2 agents, the tiebreak is to compare the total number of decision moves made by the agents.

To run the kilothon, the participants are required  to implement a main method in their code calling the following method **Kilothon.main(final String[] args);** with as arguments:
- login
- agent name

The name of the agent would have to be the name of the agent implemented by the participant.
Example: Kilothon.main(new String[]{"login", "AgentName"});

For information about how to run a kilothon from an agent made with the Java API, check this video: <TODO>
  
When a game is over during the kilothon, the rank of P1 and its obtained utility (between -1 and 1) are stored. And when all the games are over, all the results of the challenger (P1) are sent by mail to us and the sentence "Mail successfully sent! Congratulations to have played a complete kilothon!" is printed in the terminal.
All the results of the kilothon would also be available to you in a csv next to the jar run.
  
  **<b>Be careful</b>, a full kilothon is taking close to a day to play all the games and to send the results to us, do not stop the kilothon before seeing this sentence printed in your terminal. Moreover, because the results are sent to us by mail, an internet connection is required during a kilothon. **

  
  
  
  
### General Game Playing (GGP) track

During the GGP track, all participants will play against 4 other competition entrants (selecting randomly on all the other participants) on a selected set of 6 two-players games in a round-robin format (playing each role once). These games will not be named or provided to the agents beforehand. 
  
Each agent will have 30 minutes of thinking for the full game, this time can be allocated as wished. If the full time is used but the game is still not over, this participant will automatically lose the match. The agent that achieves the highest average win-rate across all games will win the competition. The win-rate for each agent across all matchups that it plays will determine its final ranking. Draws count as half a win for each of the two players.
  
All the matches will have to be played thanks to the remote mode of Ludii (requiring the participant to register on the forum, to get a login to connect yourself to the remote mode of Ludii).
All the matches will be played during the CG/IJCAI conference (23-29 July). The different matches will be announced each morning by the organizing team and the matches run during the day. All agents are required to stay online during the competition to be able to run the matches with their allocated opponents. 
  
On this track, all the two-players games in Ludii following the requirement of (#competition-games) can be used.  
  
Note: Depending on the number of submissions we receive, the number of games played could be changed. 
  
  
  
### Learning track

This track is following the same rules of the GGP except the games are going to be revealed during February and March. This allows the participants to prepare for the competition in (for example) making their agent learn more about these games before the competition. On the 20 games provided during these months, only 6 are going to be used for the actual competition. These games are all selected by the organisers of the competition.

  
  
  
  
  
## Contact Info
The preferred way to contact us with any suggestions or questions about the competition is to use the section for competitions on the Ludii forums (https://ludii.games/forums/forumdisplay.php?fid=26). This also enables other interested people to see the responses.

Alternatively, suggestions and questions may be emailed to: ludii.games@gmail.com 

These competitions are run by the members of the Digital Ludeme Project (http://ludeme.eu/people/).

  
  
  
  
## Acknowledgements

This repository is part of the European Research Council-funded Digital Ludeme Project (ERC Consolidator Grant \#771292), being run by Cameron Browne at Maastricht University's Department of Data Science and Knowledge Engineering. All prizes are funded by the PaRis Artificial Intelligence Research InstitutE (PR[AI]RIE: https://prairie-institute.fr/) thanks to Tristan Cazenave (https://www.lamsade.dauphine.fr/~cazenave/).

<a href="https://erc.europa.eu/"><img src="./resources/LOGO_ERC-FLAG_EU_.jpg" title="Funded by the European Research Council" alt="European Research Council Logo" height="384"></a>
