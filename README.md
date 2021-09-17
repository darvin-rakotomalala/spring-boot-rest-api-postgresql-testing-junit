
## Exemple test de l'API REST CRUD Spring Boot à l'aide de JUnit 
Dans ce projet, nous allons écrire des cas de test JUnit pour l'API REST Spring boot. Nous écrirons des cas de test 
pour les opérations de base de données telles que CRUD (Créer, Lire, Mettre à jour et Supprimer) d'une entité - `Product`.<br/>

Les API REST sont généralement testées rigoureusement lors des tests d'intégration. Cependant, un bon développeur 
doit tester les points de terminaison REST avant même l'intégration dans leurs tests unitaires, car ils constituent 
une partie vitale du code car il s'agit du seul point d'accès de chaque entité souhaitant utiliser les services du serveur.<br/>

### Tests d'intégration vs. tests unitaires
---
Un **test unitaire** couvre une seule «unité», où une unité est généralement une classe unique, mais peut également être un groupe de classes cohésives testées en combinaison.<br/>

Un **test d'intégration** peut être l'un des suivants :<br/>
	* un test qui couvre plusieurs « unités ». Il teste l'interaction entre deux ou plusieurs clusters de classes cohésives.
	* un test qui couvre plusieurs couches. Il s'agit en fait d'une spécialisation du premier cas et peut couvrir l'interaction entre un service métier et la couche de persistance, par exemple.
	* un test qui couvre tout le chemin à travers l'application. Dans ces tests, nous envoyons une requête à l'application et vérifions qu'elle répond correctement et a changé l'état de la base de données selon nos attentes.

### Qu'est-ce que JUnit ?
---
JUnit est l'un des frameworks de tests unitaires les plus populaires pour le développement Java. 
JUnit est pris en charge par presque tous les IDE Java et outils de construction, c'est donc le choix 
par défaut des programmeurs pour tester leur code.

#### Dépendances de la portée du test
---
Lorsque nous créons un projet Spring Boot, il ajoute par défaut une dépendance `spring-boot-starter-test` pour écrire des cas de test JUnit.<br/>
Le **spring-boot-starter-test « Starter »** (dans le test scope) contient les bibliothèques fournies suivantes :<br/>
- JUnit 5 : La norme de facto pour les tests unitaires des applications Java.
- Spring Test & Spring Boot Test : Prise en charge des utilitaires et des tests d'intégration pour les applications Spring Boot.
- AssertJ : Une bibliothèque d'assertions fluide.
- Hamcrest : Une bibliothèque d'objets matcher (également appelés contraintes ou prédicats).
- Mockito : Un framework de mocking Java.
- JSONassert : Une bibliothèque d'assertions pour JSON.
- JsonPath : XPath pour JSON.

### Prérequis
---
Pour ce projet, vous auriez besoin des spécifications suivantes :<br/>
- Spring Boot v2.0+
- JDK v1.8+
- Maven 3+ ou Gradle 4+ - outil de construction
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)
- SGBD PostgreSQL

### Dependances Maven
---
Dans ce projet nous allons utiliser les dependances Maven suivants :<br/>
- **Spring Web** - Pour inclure Spring MVC et utilise le tomcat comme conteneur intégré par défaut.
- **Spring Data JPA** - API de persistance Java et Hibernate pour persister les données dans la base de données.
- **Spring Boot DevTools** - dépendance pour les rechargements automatiques ou le rechargement en direct des applications.
- Pilote **PostgreSQL** - Pilote JDBC pour la base de données.
- **spring-boot-starter-test « Starter »** - Bibliothèques pour les tests unitaires des applications Java.

### Les annotations Spring utilisés
---
* `@SpringBootApplication` annotation pour activer une multitude de fonctionnalités, par exemple la configuration Spring basée sur Java, l'analyse des composants, et en particulier pour activer la fonction de configuration automatique de Spring Boot
* `@Entity` l'annotation doit être ajoutée à la classe d'entité, elle indique que la classe d'entité est mappée à la table de base de données
* `@Table` une annotation est ajoutée pour indiquer le nom de la table à laquelle la classe est mappée.
* `@Id` une annotation est ajoutée pour rendre le champ identifié de manière unique, ce n'est rien d'autre que la clé primaire
* `@Column` une annotation est ajoutée pour spécifier le nom de la colonne.
* `@SpringBootTest` fournie par Spring Boot pour activer des fonctionnalités spécifiques au démarrage dans les tests d'application lors des tests unitaires ou des tests d'intégration.
* `@Order` et `@TestMethodOrder` l'annotation spécifiera l'ordre d'exécution car JUnit n'exécute pas les méthodes de test dans l'ordre dans lequel elles apparaissent dans le code.
* `@Autowired` permet d’activer l’injection automatique de dépendance.

### Exécuter les tests
---
À l'intérieur de `src/test/java` on crée `ProductTest.java`, où nous écrirons des cas de test unitaires pour l'entité `Product`.
Nous utilisons la méthode `assertThat()` de la bibliothèque `AssertJ` pour plus de lisibilité que d'utiliser les méthodes d'assertion de JUnit.<br/>
`$ mvn test` - Exécutez toutes les classes de test unitaire.<br/>
- **Scénario de test pour l'opération de sauvegarde** - cas de test unitaire pour enregistrer les détails du produit dans la base de données.
- **Cas de test pour l'opération de lecture** - cas de test unitaire pour lire tous les produits de la base de données.
- **Cas de test pour l'opération de lecture** - cas de test unitaire pour lire tous et un seul produits de la base de données.
- **Scénario de test pour l'opération de mise à jour** - cas de test unitaire pour mettre à jour les détails du produit.
- **Scénario de test pour l'opération de suppression** - cas de test unitaire pour supprimer le produit.

![testJUnit](https://user-images.githubusercontent.com/75081354/133749982-12e0ae8a-89d7-4040-9a86-b74f16b9ca7e.PNG)


