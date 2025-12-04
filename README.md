# Medical Expert System 

> 📌 **Note:** This is an **educational project only**.
> It is **NOT** a real medical tool and must **never** be used for actual diagnosis or treatment. 
> Always consult a qualified doctor for real health issues.

---

## 📖 Project Overview

This project is a **rule-based expert system** that suggests **general medicine categories** and **basic advice** based on user-selected symptoms.

The system asks the user to choose symptoms from a menu (fever, cough, headache, etc.), then applies a set of **IF–THEN rules** to:

- Guess a **possible condition type** (very roughly, only for learning)
- Suggest a **medicine category** (e.g., “fever and pain management”, “cough relief category”)
- Print **general safety advice** and warnings

It demonstrates how an **expert system** works using:

- A basic **knowledge base** (rules)
- An **inference engine** (logic that matches symptoms to rules)
- A **user interface** (console-based Q&A)

---

## 🎯 Features

- Console-based, menu-driven interface
- Multiple symptoms can be selected in one case
- Simple **rule engine**:
  - Fever + cough + sore throat/runny nose → cold/flu-like
  - Fever + headache + body pain → viral fever-like
  - Headache only → headache/migraine-like
  - Stomach pain + nausea → gastric/indigestion-like
  - Skin rash only → mild allergy/irritation-like
- For each case, system provides:
  - A **rough condition guess**
  - A **general medicine category** (not actual drug names)
  - **General advice** and **safety warnings**
- Option to **check another case** without restarting the program

---

## 🛠 Tech Stack

- **Language:** Java
- **Type:** Console application
- **Paradigm:** Rule-based expert system (IF–THEN rules)

---

## 🧬 How It Works (Expert System Concept)

The system follows the structure of a **simple expert system**:

### 1. Knowledge Base
This is a collection of **rules** defined in code:

```text
IF fever AND cough AND (sore throat OR cold)
    THEN suggest "Cold/flu-like" + category + advice

IF fever AND headache AND body pain
    THEN suggest "Viral fever-like" + category + advice

IF headache only
    THEN suggest "Headache/migraine-like" + category + advice

...
ELSE
    Unclear → advise to consult a doctor

