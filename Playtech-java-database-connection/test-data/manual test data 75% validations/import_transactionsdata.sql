INSERT INTO Transactions (TRANSACTION_ID, USER_ID, TYPE, AMOUNT, METHOD, ACCOUNT_NUMBER)
SELECT TRANSACTION_ID, USER_ID, TYPE, AMOUNT, METHOD, ACCOUNT_NUMBER FROM OPENROWSET(
    BULK '/Users/liisikuuskull/Desktop/Playtech-java-database-connection/test-data/transactions.csv',
    FORMAT = 'CSV',
    FIRSTROW = 2 -- Ignore header row if present
) AS Transactions;
