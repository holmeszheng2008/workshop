# My assumptions for the Single Cash Flow Trade PRD

Pick the THREE gaps you think matter most. For each one, write the question and the default you will build on.
Keep each cell to one short line.

| # | Requirement (FR number) | Question for the product owner | My default until they answer |
|---|---|---|---|
| 1 | FR8 | What request key makes a retry duplicate-safe, how long is it retained, and should the same key with different trade data be rejected? | Require an `Idempotency-Key`; retain mappings indefinitely, and reject key reuse with changed data. |
| 2 | FR1, FR7 | What maximum decimal precision and rounding rule apply to ounces and agreed price, and is each exact monetary/quantity value stored without floating point? | Use decimal types; ounce quantity to 6 decimal places and price to 8, with explicit half-up rounding only at capture. |
| 3 | FR3, FR4, FR9 | Who may create, amend, cancel, and view trades, and which actor/action/timestamp/data changes must every audit event retain? | Allow sales/traders to create/amend/cancel before settlement, operations to read-only, and log actor, role, action, timestamps, and before/after values. |

Riskiest of the three (one line, and why): FR8: duplicate or mismatched retries could create or alter financial trades and are expensive to reconcile safely.
