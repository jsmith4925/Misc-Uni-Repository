factors :: Integer -> [Integer]
factors n = [x | x <- [1..n], n `mod` x == 0]

prime :: Integer -> Bool
prime n = factors n == [1,n]

primesBelow :: Integer -> [Integer]
primesBelow n = [x | x <- [1..n], prime x == True]

allPrimes :: [Integer]
allPrimes = [x | x <- [2..], prime x]

primeTest :: [Bool]
primeTest 