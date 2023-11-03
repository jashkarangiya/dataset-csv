def min_coins(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0

    for coin in coins:
        for i in range(coin, amount + 1):
            dp[i] = min(dp[i], dp[i - coin] + 1)

    return dp[amount]

# Test cases
test_cases = [
    ([1, 2, 3, 5], 5),
    ([18, 17, 5, 1], 22),
    ([100, 25, 10, 5, 1], 289),
]

for i, (coins, amount) in enumerate(test_cases):
    result = min_coins(coins, amount)
    print(f"Test Case {i+1}: Coins required for ₹{amount} with denominations {coins} = {result}")
