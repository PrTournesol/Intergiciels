TP RMI
======

Objectifs
---------

Le système est constitué d'un objet de type `Carnet`, dans lequel on range des
Individus.

Un Individu possède un nom et un âge. Le nom et l'âge sont fixés à la
création, et l'âge augmente via la méthode `fêter_anniversaire`.

Un `Carnet` stocke des Individus. On peut en outre chercher un individu par
nom, par numéro d'ordre ou les obtenir tous.

Version 1 : seul le Carnet est accessible à distance. Les Individus sont
sérialisables (accès par valeur/copie). Commencer par écrire uniquement la
partie cliente (`IndividuImpl.java` et `ClientTxt.java`) et tester avec le
serveur founi dans le répertoire Solution. Puis compléter `CarnetImpl.java`
et `ServeurCarnet.java`.

Version 2 : le Carnet et les Individus sont accessibles à distance (accès
par référence).

L'objectif du tp est de mettre en oeuvre ces deux versions et d'observer la
différence, notamment en insérant des traces dans les méthodes.

Version 3 : on ajoute un "callback" pour qu'un client puisse s'abonner et
être informé quand un nouvel Individu est créé. Ce callback implante
l'interface `CallbackOnCreation`

----------------------------------------------------------------

Sources fournies
----------------

Les sources fournies :

* `Carnet.java` : l'interface d'un objet Carnet.
* `CarnetImpl.java` : l'implantation d'un objet Carnet. INCOMPLET.
* `IndividuInexistant.java` : exception levée par Carnet.
* `Individu.java` : l'interface d'un objet Individu.
* `ServeurCarnet.java` : pgm principal créant un objet carnet. INCOMPLET.
* `ClientTxt.java` : client de l'objet carnet. INCOMPLET.
* `CallbackOnCreation.java` : l'interface du callback de création.

* `ClientGraph.java` : autre client graphique. Complet mais peu compréhensible en premier abord.

Classes à écrire intégralement :

* `IndividuImpl.java` : implantation d'un objet Individu.

----------------------------------------------------------------

Solution
--------

Dans le sous-répertoire Solution/carnet, vous trouverez (en version compilée) :

* ServeurCarnet 
* ClientTxt     
* ClientGraph   comme ClientTxt en plus joli.
* Peupleur      crée plusieurs individus et les insère dans le carnet.

Démarrage (depuis le répertoire contenant le répertoire `carnet`) :

    java carnet.ServeurCarnet
    java carnet.ClientTxt [registryhost]
    java carnet.ClientGraph [registryhost]
    java carnet.Peupleur [registryhost]
