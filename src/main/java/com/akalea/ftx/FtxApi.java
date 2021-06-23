package com.akalea.ftx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akalea.ftx.domain.Account;
import com.akalea.ftx.domain.Auth;
import com.akalea.ftx.domain.Market;
import com.akalea.ftx.domain.Order;
import com.akalea.ftx.domain.SubAccount;
import com.akalea.ftx.domain.SubAccountBalance;
import com.akalea.ftx.impl.FtxAccountsImpl;
import com.akalea.ftx.impl.FtxMarketsImpl;
import com.akalea.ftx.impl.FtxOrdersImpl;

@Service
public class FtxApi {
    @Autowired
    private FtxAccountsImpl accounts;
    @Autowired
    private FtxMarketsImpl  markets;
    @Autowired
    private FtxOrdersImpl   orders;

    public AuthenticatedFtxApi withAuth(Auth auth) {
        return new AuthenticatedFtxApi().setAuth(auth);
    }

    public Accounts accounts() {
        return accounts;
    }

    public Markets markets() {
        return markets;
    }

    public Orders orders() {
        return orders;
    }

    public static interface Accounts {
        Account getAccount(Auth auth);

        List<SubAccount> getSubAccounts(Auth auth);

        List<SubAccountBalance> getSubAccountBalances(String nickname, Auth auth);
    }

    public static interface AccountsAuth {
        Account getAccount();

        List<SubAccount> getSubAccounts();

        List<SubAccountBalance> getSubAccountBalances(String nickname);
    }

    public static interface Orders {
        Order placeOrder(Order order, Auth auth);
    }

    public static interface OrdersAuth {
        Order placeOrder(Order order);
    }

    public static interface Markets {
        List<Market> getMarkets(Auth auth);
    }

    public static interface MarketsAuth {
        List<Market> getMarkets();
    }

    public static class AuthenticatedFtxApi {
        private FtxApi api;
        private Auth   auth;

        public AccountsAuth accounts() {
            return new AccountsAuth() {

                @Override
                public Account getAccount() {
                    return api.accounts.getAccount(auth);
                }

                @Override
                public List<SubAccount> getSubAccounts() {
                    return api.accounts.getSubAccounts(auth);
                }

                @Override
                public List<SubAccountBalance> getSubAccountBalances(String nickname) {
                    return api.accounts.getSubAccountBalances(nickname, auth);
                }

            };
        }

        public MarketsAuth markets() {
            return new MarketsAuth() {

                @Override
                public List<Market> getMarkets() {
                    return api.markets.getMarkets(auth);
                }

            };
        }

        public OrdersAuth orders() {
            return new OrdersAuth() {

                @Override
                public Order placeOrder(Order order) {
                    return api.orders.placeOrder(order, auth);
                }

            };
        }

        public FtxApi getApi() {
            return api;
        }

        public AuthenticatedFtxApi setApi(FtxApi api) {
            this.api = api;
            return this;
        }

        public Auth getAuth() {
            return auth;
        }

        public AuthenticatedFtxApi setAuth(Auth auth) {
            this.auth = auth;
            return this;
        }

    }

}
