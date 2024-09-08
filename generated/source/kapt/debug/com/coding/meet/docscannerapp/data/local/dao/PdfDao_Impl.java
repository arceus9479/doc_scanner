package com.coding.meet.docscannerapp.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.coding.meet.docscannerapp.data.local.converters.DateTypeConverter;
import com.coding.meet.docscannerapp.data.models.PdfEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PdfDao_Impl implements PdfDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PdfEntity> __insertionAdapterOfPdfEntity;

  private final DateTypeConverter __dateTypeConverter = new DateTypeConverter();

  private final EntityDeletionOrUpdateAdapter<PdfEntity> __deletionAdapterOfPdfEntity;

  private final EntityDeletionOrUpdateAdapter<PdfEntity> __updateAdapterOfPdfEntity;

  public PdfDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPdfEntity = new EntityInsertionAdapter<PdfEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pdfTable` (`pdfId`,`name`,`size`,`lastModifiedTime`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PdfEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getSize() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSize());
        }
        final long _tmp = __dateTypeConverter.dateToTimestamp(entity.getLastModifiedTime());
        statement.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfPdfEntity = new EntityDeletionOrUpdateAdapter<PdfEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pdfTable` WHERE `pdfId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PdfEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfPdfEntity = new EntityDeletionOrUpdateAdapter<PdfEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `pdfTable` SET `pdfId` = ?,`name` = ?,`size` = ?,`lastModifiedTime` = ? WHERE `pdfId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PdfEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getSize() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSize());
        }
        final long _tmp = __dateTypeConverter.dateToTimestamp(entity.getLastModifiedTime());
        statement.bindLong(4, _tmp);
        if (entity.getId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertPdf(final PdfEntity pdf, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPdfEntity.insertAndReturnId(pdf);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePdf(final PdfEntity pdf, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __deletionAdapterOfPdfEntity.handle(pdf);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePdf(final PdfEntity pdf, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __updateAdapterOfPdfEntity.handle(pdf);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PdfEntity>> getAllPdfs() {
    final String _sql = "SELECT * FROM pdfTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pdfTable"}, new Callable<List<PdfEntity>>() {
      @Override
      @NonNull
      public List<PdfEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
          final int _cursorIndexOfLastModifiedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastModifiedTime");
          final List<PdfEntity> _result = new ArrayList<PdfEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PdfEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSize;
            if (_cursor.isNull(_cursorIndexOfSize)) {
              _tmpSize = null;
            } else {
              _tmpSize = _cursor.getString(_cursorIndexOfSize);
            }
            final Date _tmpLastModifiedTime;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfLastModifiedTime);
            _tmpLastModifiedTime = __dateTypeConverter.fromTimestamp(_tmp);
            _item = new PdfEntity(_tmpId,_tmpName,_tmpSize,_tmpLastModifiedTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<PdfEntity> getAllPdfsWithOutFlow() {
    final String _sql = "SELECT * FROM pdfTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfId");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfSize = CursorUtil.getColumnIndexOrThrow(_cursor, "size");
      final int _cursorIndexOfLastModifiedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastModifiedTime");
      final List<PdfEntity> _result = new ArrayList<PdfEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final PdfEntity _item;
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpSize;
        if (_cursor.isNull(_cursorIndexOfSize)) {
          _tmpSize = null;
        } else {
          _tmpSize = _cursor.getString(_cursorIndexOfSize);
        }
        final Date _tmpLastModifiedTime;
        final long _tmp;
        _tmp = _cursor.getLong(_cursorIndexOfLastModifiedTime);
        _tmpLastModifiedTime = __dateTypeConverter.fromTimestamp(_tmp);
        _item = new PdfEntity(_tmpId,_tmpName,_tmpSize,_tmpLastModifiedTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
