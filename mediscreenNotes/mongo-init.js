db = db.getSiblingDB('mediscreen');


db.createCollection('note');

db.note.insertMany([
    {
        patId: 1,
        Patient: 'TestNone',
        "Practitioner's notes/recommendations": "Patient states that they are 'feeling terrific' Weight at or below recommended level",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 2,
        Patient: 'TestBorderline',
        "Practitioner's notes/recommendations": "Patient states that they are feeling a great deal of stress at work Patient also complains that their hearing seems Abnormal as of late",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 2,
        Patient: 'TestBorderline',
        "Practitioner's notes/recommendations": "Patient states that they have had a Reaction to medication within last 3 months Patient also complains that their hearing continues to be problematic",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 3,
        Patient: 'TestInDanger',
        "Practitioner's notes/recommendations": "Patient states that they are short term Smoker ",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 3,
        Patient: 'TestInDanger',
        "Practitioner's notes/recommendations": "Patient states that they quit within last year Patient also complains that of Abnormal breathing spells Lab reports Cholesterol LDL high",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 4,
        Patient: 'TestEarlyOnset',
        "Practitioner's notes/recommendations": "Patient states that walking up stairs has become difficult Patient also complains that they are having shortness of breath Lab results indicate Antibodies present elevated Reaction to medication",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 4,
        Patient: 'TestEarlyOnset',
        "Practitioner's notes/recommendations": "Patient states that they are experiencing back pain when seated for a long time",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 4,
        Patient: 'TestEarlyOnset',
        "Practitioner's notes/recommendations": "Patient states that they are a short term Smoker Hemoglobin A1C above recommended level",
        Date: new Date("2023-04-20T22:00:00.000Z")
    },
    {
        patId: 4,
        Patient: 'TestEarlyOnset',
        "Practitioner's notes/recommendations": "Patient states that Body Height, Body Weight, Cholesterol, Dizziness and Reaction",
        Date: new Date("2023-04-20T22:00:00.000Z")
    }
]);


