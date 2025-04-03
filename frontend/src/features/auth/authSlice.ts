import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface AuthState {
  user: null | {
    id: string;
    username: string;
    email: string;
    roles: string[];
    accessToken: string;
  };
  isAuthenticated: boolean;
  isLoading: boolean;
  error: string | null;
}

const initialState: AuthState = {
  user: null,
  isAuthenticated: false,
  isLoading: false,
  error: null
};

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    loginStart(state) {
      state.isLoading = true;
      state.error = null;
    },
    loginSuccess(state, action: PayloadAction<AuthState['user']>) {
      state.user = action.payload;
      state.isAuthenticated = true;
      state.isLoading = false;
    },
    loginFailure(state, action: PayloadAction<string>) {
      state.isLoading = false;
      state.error = action.payload;
    },
    logout(state) {
      state.user = null;
      state.isAuthenticated = false;
    }
  }
});

export const { loginStart, loginSuccess, loginFailure, logout } = authSlice.actions;
export default authSlice.reducer;