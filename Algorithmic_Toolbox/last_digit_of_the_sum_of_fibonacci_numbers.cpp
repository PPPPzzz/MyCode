#include <iostream>
#include <vector>

int fibonacci_sum_naive(long long n) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current = 1;
    long long sum = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
        sum += current;
    }

    return sum % 10;
}

int fibonacci_sum_fast(long long n)
{
    if (n <= 1)
        return n;

    long long last_digit = 0;
    long long previous = 0;
    long long current = 1;
    std::vector<int> sum;

    sum.push_back(0);
    sum.push_back(1);
    for (int i = 2; i < n; i++)
    {
        sum.push_back((previous + current) % 10);
        previous = current;
        current = sum.back();
    }
    for (int i = 0; i < n; i++)
        last_digit = sum[i];
    last_digit %= 10;

    return last_digit;
}

int main() {
    long long n = 0;
    std::cin >> n;
    std::cout << fibonacci_sum_naive(n);
}
