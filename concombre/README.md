🥒 Concombre 🇫🇷
===

Parce que vos clients seront surement nativement francophones, on va mettre en oeuvre Cucumber, et principalement la [syntaxe Gherkin](https://cucumber.io/docs/gherkin/languages/#gherkin-dialect-fr-content), dans sa localisation française.

Comme base d'exercice, un petit [jeu de pendu](src/main/java/software_engineering/univ_lorraine/spoonless/jeu/JeuDuPendu.java) et un [Gherkin en français](src/test/resources/software_engineering/univ_lorraine/polytech_nancy/jeu/ProposerLettre.feature).

- [ ] Définissez suffisament d'[étapes](src/test/java/software_engineering/univ_lorraine/polytech_nancy/jeu/JeuDuPenduSteps.java) pour réussir les tests de scénarios déjà écrits. Si vous êtes encore perdu face aux expressions régulières des annotations (e.g. `@Given(expr)`), jetez un oeil à la [doc](https://cucumber.io/docs/cucumber/step-definitions/?lang=java#expressions) ; notamment sur les "expressions concombre".
- [ ] Transformez les scénarios en [plan de scénarios](https://cucumber.io/docs/gherkin/reference/#scenario-outline) afin de multiplier les exemples.
- [ ] Rajoutez un ou des scénarios pour gérer les répétitions de lettre, pour proposer directement un mot, etc.
- [ ] Réussissez ces scéanrios.
- [ ] Ecrivez des (plans de) scénarios pour que les parties est une fin, victoire ou défaite, dans un nouveau fichier `.feature`.
- [ ] Réussissez tous ces tests de validation.
- [ ] Cocorico!