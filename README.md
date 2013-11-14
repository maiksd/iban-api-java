# Java-API for Generation/Validation IBAN (TODO: Anpassen Link ->)[![Build Status](https://travis-ci.org/aventum-solutions/eclipse-websearch.png?branch=master)](https://travis-ci.org/aventum-solutions/eclipse-websearch)

Open Source Java-API for generating an IBAN from a given bank account and validate an IBAN.

## Quick Start

Two quick start options are available:

* [Download the latest release](https://github.com/aventum-solutions/eclipse-websearch/tree/master/jar/org.as.plugin.websearch-0.2.0.jar) (TODO: Anpassen Link) and add it to your Java classpath
* Build from sourcecode


## Build from sourcecode

* Install maven if necessary [Download and Documentation](http://maven.apache.org/run-maven/index.html)
* Clone the repo with 'git clone git://github.com/aventum-solutions/eclipse-websearch.git' into an arbitrary directory
* Open a commandline and go into that directory
* Execute 'mvn clean package'
* Add the generated Java Archive to your Java classpath


## Using the API
* Javadoc of the current release is available here (TODO: Anpassen Link)

---
* For generating an Iban for a given bank account just call the constructor from interface 'Iban' with the following parameters
 * The country code for which the IBAN should be generated (valid country codes available in interface Iban)
 * The bank code in your national format
 * The account nummber
* For each available country the format of the bank code and account number is checked
* In case of german country code there are additonal rules implemented for building the IBAN. More information about the rules published by the Bundesbank are available [here](http://www.bundesbank.de/Navigation/DE/Kerngeschaeftsfelder/Unbarer_Zahlungsverkehr/IBAN_Regeln/iban_regeln.html)

---
* For validating an IBAN just use the constructor form interface 'Iban' with the given IBAN-String and call the 'validate'-method.
* The additional rules for german banks are also considered.
* In case of german banks the BIC can be determined by using the method 'getBic()' from Interface 'Iban'

---
* In case of failures during generation/validation the IBAN an 'IbanException' will be thrown. See the Javadoc for a detailed description of the used messages


## Copyright and license

TODO