# language: fr

Fonctionnalité: Proposer une lettre
  En tant que joueur, 
  Afin de deviner le mot secret, 
  Je souhaite proposer une lettre.

Scénario: Connaître l'occurence d'une lettre dans le mot secret
  Étant donné que le mot secret est "cucumber"
  Quand le joueur propose la lettre "u"
  Alors la lettre est présente 2 fois

Scénario: Connaitre la position de toutes les occurences dans le mot secret
  Étant donné que le mot secret est "cucumber"
  Quand le joueur propose la lettre "u"
  Alors le mot deviné est au moins "-u-u----"
